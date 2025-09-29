$(document).ready(function() {
    $("#bookNoCheckBtn").on("click", function(event) {
        event.preventDefault();

        let bookNo = $("#bookNo").val();

        if (bookNo == "") {
            alert("도서번호를 입력해주세요.");
            $("#bookNo").focus();
            return false;
        } else {
            fetch("/book/bookNoCheck/" + bookNo)
                .then(response => response.text())
                .then(result => {
                    if (result == "available") {
                        alert("사용 가능한 도서번호입니다.");
                    } else {
                        alert("이미 사용 중인 도서번호입니다.");
                        $("#bookNo").val("");
                        $("#bookNo").focus();
                    }
                })
                .catch(error => console.log(error));
        } // else
    })
})