$(document).ready(function () {
    $('#bookSearchFrm').on('submit', function (event) {
        event.preventDefault();

        let formData = $(this).serialize();

        let keyword = $('#keyword').val();
        let type = $('#type').val();

        if (keyword == "" && type == "") {
            alert("검색 조건과 검색어를 입력하세요");
        } else {
            $.ajax({
                type: 'POST',
                url: '/book/bookSearch',
                data: formData, // 요청 시 전송될 파라미터
                success: (result) => {
                    console.log(result);
                    $('#searchResultBox').empty(); // 이전 검색 결과 초기화
                    $('#searchResultBox').append('<table id=\"resultTable\" border=\"1\" width=\"500">' +
                        '<tr><th>도서번호</th><th>도서명</th><th>저자</th>' +
                        '<th>도서가격</th><th>제조일</th><th>재고</th><th>출판사번호</th></tr>');

                    if (result == "") {
                        $('#searchResultBox').append('<tr align="center"><td colspan="7">검색 결과가 없습니다.</td></tr>');
                    } else {
                        for (let i = 0; i < result.length; i++) {
                            let prd_date = new Date(result[i].bookDate);
                            let year = prd_date.getFullYear();
                            let month = (prd_date.getMonth() + 1).toString().padStart(2, '0');
                            let date = prd_date.getDate().toString().padStart(2, '0');
                            let bookDate = `${year}-${month}-${date}`;
                            $('#resultTable').append('<tr><td>' + result[i].bookNo + '</td>' +
                                '<td>' + result[i].bookName + '</td>' +
                                '<td>' + result[i].bookAuthor + '</td>' +
                                '<td>' + result[i].bookPrice + '</td>' +
                                '<td>' + bookDate + '</td>' +
                                '<td>' + result[i].bookStock + '</td>' +
                                '<td>' + result[i].pubNo + '</td></tr>');
                        }
                    }
                    $('#searchResultBox').append('</table>');
                },
                error: function () {
                    alert("요청 실패");
                }
            });
        }
    });
});
