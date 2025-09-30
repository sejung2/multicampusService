$(document).ready(function () {
    $('#imageFileFrm').on('submit', function (event) {
        event.preventDefault();

        let formData = new FormData($('#imageFileFrm')[0]);

        let fileName = $('#uploadFile').val().split("\\").pop(); // 파일명만 추출 -> 이미지 출력을 위함
        // 서버에 요청 후 결과 받아서 클라이언트에서 처리

        $.ajax({
            type: 'POST',
            url: '/imageFileUpload',
            enctype: "/multipart/form-data",
            processData: false,
            contentType: false,
            data: formData, // 요청 시 전송될 파라미터
            success: (result) => {
                if(result == "success") {
                    // imageBox에 이미지 출력
                    $('#imageBox').html('<img src="/images/' + fileName + '" width="400" height="300">');
                }
            },
            error: function () {
                alert("업로드 요청 실패");
            },
            complete: function () {
                // alert("작업 완료");
            }
        });
    });
});
