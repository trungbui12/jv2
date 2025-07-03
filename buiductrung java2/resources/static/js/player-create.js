document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    form.addEventListener("submit", function (e) {
        const name = document.querySelector("#playerName").value;
        if (name.trim().length < 3) {
            alert("Tên người chơi phải có ít nhất 3 ký tự.");
            e.preventDefault();
        }
    });
});
