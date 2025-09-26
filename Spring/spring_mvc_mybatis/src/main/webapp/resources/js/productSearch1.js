$(document).ready(function () {
    $('#prdSearchFrm1').on('submit', function (event) {
        event.preventDefault();

        // 폼에 입력된 여러개의 값을 쿼리 스트링 방식의 데이터로 변환: serialize() 사용
        let formData = $(this).serialize();

        let keyword = $('#keyword').val();
        let type = $('#type').val();

        if (keyword == "" && type == "") {
            alert("검색 조건과 검색어를 입력하세요");
            // return false;
        } else {
            $.ajax({
                type: 'POST',
                url: '/product/productSearch1',
                data: formData, // 요청 시 전송될 파라미터
                success: (result) => {
                    if (result == "success") {
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
                }
            });
        }
    });
});
