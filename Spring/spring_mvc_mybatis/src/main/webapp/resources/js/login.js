$(document).ready(function () {
    $('#frmLogin').on('submit', function (event) {
        event.preventDefault();

        let user_id = $('#user_id').val();
        let user_pw = $('#user_pw').val();

        console.log(user_id, user_pw);

        $.ajax({
            type: 'POST',
            url: '/login',
            data: {
                "user_id": user_id,
                "user_pw": user_pw
            },
            dataType: "text",
            success: (result) => {
                let message;
                if(result == "success") {
                    message = "로그인 성공";
                } else {
                    message = "로그인 실패";
                }
                alert(message);
            },
            error: function () {
                alert("요청 실패");
            },
            complete: function () {
                alert("작업 완료");
            }
        });
    });
});
