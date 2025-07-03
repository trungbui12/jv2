document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".btn-danger");

    deleteButtons.forEach(function (btn) {
        btn.addEventListener("click", function (e) {
            const confirmed = confirm("Bạn có chắc muốn xoá người chơi này không?");
            if (!confirmed) {
                e.preventDefault();
            }
        });
    });
});
