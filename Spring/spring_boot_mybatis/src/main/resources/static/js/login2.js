$(document).ready(function () {
    $('#frmLogin2').on('submit', function (event) {
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
                if(result == "success") {
                    {
                        alert("로그인 성공\n 상품 조회 화면으로 이동합니다.");
                        location.href = "/product/listAllProduct";
                    }
                } else {
                    alert("로그인 실패");
                }
            },
            error: function () {
                alert("요청 실패");
            },
            complete: function () {
                // alert("작업 완료");
            }
        });
    });
});
