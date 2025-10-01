$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/member/login',
            data: {
                "id": $('#id').val(),
                "pwd": $('#pwd').val()
            },
            dataType: 'text',
            success: function (result) {
                if (result === "success") {
                    alert("로그인 성공 \n메인 페이지로 이동합니다.");
                    location.href = "/"; // 메인 페이지로 이동
                } else {
                    alert("아이디 또는 비밀번호가 일치하지 않습니다.");
                }
            },
            error: function () {
                alert("요청 실패");
            },

        }); // ajax

    }); // submit
}); // document.ready