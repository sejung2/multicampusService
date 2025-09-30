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
            // 라이브러리 axios.post(url, data(key:value)).then(function(response){처리코드})
            let data = { "prdNo": prdNo };
            axios.get("/product/prdNoCheck5", data)
                .then(function(response) {
                    if (response.data == "available") {
                        alert("사용 가능한 상품번호입니다.");
                    } else {
                        alert("이미 사용 중인 상품번호입니다.");
                        $("#prdNo").val("");
                        $("#prdNo").focus();
                    }
                })
                .catch(err => console.log(err));
        } // else
    })
});

// fetch(url) : url로 요청
// 서버: 객체 반환 -> Promise 객체를 반환
// 첫 번째.then() : 반환된 객체의 promise가 성공적으로 완료되면 두 번째 then 콜백이 실행됨
// 두 번째.then(Http Response 객체를 전달받음): 전달받은 res 객체를 json(), text() 변환해서 사용