function validateForm() {
    const form = document.getElementById("survey");
    const radioGroups = form.querySelectorAll('input[type="radio"]');
    let isAllAnswered = true;

    radioGroups.forEach((radio) => {
        const groupName = radio.getAttribute("name");
        const group = form.querySelectorAll(`input[name="${groupName}"]`);
        let isChecked = false;

        group.forEach((radio) => {
            if (radio.checked) {
                isChecked = true;
            }
        });

        if (!isChecked) {
            isAllAnswered = false;
        }
    });

    return isAllAnswered;
}
document.getElementById("survey").addEventListener("submit", function (event) {
    if (!validateForm()) {
        event.preventDefault(); // Prevent form submission if not all questions are answered
        alert("모든 문항에 답을 해주세요");
    }
});