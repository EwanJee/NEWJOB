// JavaScript (js/index.js)
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('survey');
    const submitButton = document.getElementById('submit');
    const radioButtons = form.querySelectorAll('.radio-btn');

    // 라디오 버튼의 변경을 감지하여 submit 버튼 활성화/비활성화
    radioButtons.forEach(radio => {
        radio.addEventListener('change', function() {
            // 모든 라디오 버튼이 선택되었는지 확인
            const allChecked = [...radioButtons].every(radio => radio.checked);
            submitButton.disabled = !allChecked; // 선택 안 됐으면 비활성화
        });
    });
});




