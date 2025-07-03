document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    form.addEventListener("submit", function (e) {
        const level = document.querySelector("#level").value;
        if (level < 1) {
            alert("Cấp độ phải lớn hơn 0.");
            e.preventDefault();
        }
    });
});
