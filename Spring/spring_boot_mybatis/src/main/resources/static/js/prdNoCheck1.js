$(document).ready(function () {
    $("#prdNoCheckBtn").on("click", function(event) {
        event.preventDefault();

        let prdNo = $("#prdNo").val();

        if (prdNo === "") {
            alert("상품번호를 입력해주세요.");
            $("#prdNo").focus();
            return false;
        } else {
            // 서버측에 상품번호 중복 확인 요청
            $.ajax({
                type: "GET",
                url: "/product/prdNoCheck1/" + prdNo, // url에 포함되는 값을 path variable이라고 부른다. 이 요청방식이 RESTful 방식이다.
                data: {
                    "prdNo": prdNo
                },
                dataType: "text",
                success: (result) => {
                    if (result == "available") {
                        alert("사용 가능한 상품번호입니다.");
                    } else {
                        alert("이미 사용 중인 상품번호입니다.");
                        $("#prdNo").val("");
                        $("#prdNo").focus();
                    }
                },
                error: (data, textStatus) => {
                    alert("요청 실패");
                }
            });
        }
    })
});