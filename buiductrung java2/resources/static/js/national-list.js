document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".btn-danger");

    deleteButtons.forEach(function (btn) {
        btn.addEventListener("click", function (e) {
            const confirmed = confirm("Xoá quốc gia này sẽ ảnh hưởng đến người chơi liên quan. Bạn chắc chứ?");
            if (!confirmed) {
                e.preventDefault();
            }
        });
    });
});
