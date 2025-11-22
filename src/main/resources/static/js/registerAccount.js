// registerAccount.js

document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registerForm');
    const submitBtn = document.getElementById('submitBtn');
    const messageArea = document.getElementById('messageArea');

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        // 중복 제출 방지
        if (submitBtn.disabled) return;
        
        // 폼 데이터 수집
        const formData = collectFormData();
        
        // 유효성 검사
        if (!validateForm(formData)) {
            return;
        }
        
        // 회원가입 요청
        submitRegistration(formData);
    });

    /**
     * 폼 데이터 수집
     */
    function collectFormData() {
        // 체크된 역할 수집
        const roleTypes = Array.from(document.querySelectorAll('input[name="roleTypes"]:checked'))
            .map(checkbox => checkbox.value);

        return {
            email: document.getElementById('email').value.trim(),
            password: document.getElementById('password').value,
            username: document.getElementById('username').value.trim(),
            tel: document.getElementById('tel').value.trim(),
            gender: document.getElementById('gender').value,
            birthDate: document.getElementById('birthDate').value,
            country: document.getElementById('country').value.trim(),
            university: document.getElementById('university').value.trim(),
            workType: document.getElementById('workType').value,
            zipcode: document.getElementById('zipcode').value.trim(),
            address: document.getElementById('address').value.trim(),
            addressDetail: document.getElementById('addressDetail').value.trim(),
            roleTypes: roleTypes
        };
    }

    /**
     * 유효성 검사
     */
    function validateForm(data) {
        // 필수 항목 체크
        if (!data.email) {
            showMessage('이메일을 입력해주세요.', 'error');
            return false;
        }
        
        if (!data.password) {
            showMessage('비밀번호를 입력해주세요.', 'error');
            return false;
        }
        
        if (!data.username) {
            showMessage('이름을 입력해주세요.', 'error');
            return false;
        }

        // 이메일 형식 검사
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(data.email)) {
            showMessage('올바른 이메일 형식이 아닙니다.', 'error');
            return false;
        }

        // 전화번호 형식 검사 (입력된 경우)
        if (data.tel) {
            const telPattern = /^\d{10,11}$/; // 10~11자리 숫자
            if (!telPattern.test(data.tel)) {
                showMessage('전화번호 형식이 올바르지 않습니다. (예: 01012345678)', 'error');
                return false;
            }
        }

        return true;
    }

    /**
     * 회원가입 요청
     */
    function submitRegistration(data) {
        submitBtn.disabled = true;
        submitBtn.textContent = '처리 중...';

        fetch('/admin/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json()) // JSON으로 변환
        .then(result => {
            if (!result.success) {
                // API에서 내려온 메시지로 오류 처리
                throw new Error(result.result || '회원가입 중 오류가 발생했습니다.');
            }

            // 성공 시
            alert(result.result); // "회원가입 성공!" 메시지 표시
            window.location.href = '/'; // 로그인 페이지 이동
        })
        .catch(error => {
            console.error('회원가입 실패:', error);
            showMessage(error.message, 'error');

            submitBtn.disabled = false;
            submitBtn.textContent = '회원가입';
        });
    }

    /**
     * 메시지 표시
     */
    function showMessage(message, type) {
        messageArea.innerHTML = `<div class="message ${type}">${message}</div>`;
        
        // 3초 후 메시지 자동 제거 (에러가 아닌 경우)
        if (type !== 'error') {
            setTimeout(() => {
                messageArea.innerHTML = '';
            }, 3000);
        }
    }

});