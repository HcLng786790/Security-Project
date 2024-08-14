//document.getElementById("registerForm").addEventListener("submit", function(event) {
//    event.preventDefault();
//
//    var formData = {
//        username: document.getElementById("username").value,
//        password: document.getElementById("password").value
//    };
//
//    fetch('/register', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json'
//        },
//        body: JSON.stringify(formData)
//    })
//    .then(response => {
//        if (!response.ok) {
//            throw new Error('Network response was not ok');
//        }
//        return response.json();
//    })
//    .then(data => {
//        document.getElementById("message").innerText = "Registration successful for " + data.username;
//        document.getElementById("message").classList.add("success");
//        document.getElementById("message").style.display = "block";
//
//        setTimeout(function() {
//            window.location.href = '/login';
//        }, 2000);
//    })
//    .catch(error => {
//        console.error('There was a problem with the registration:', error);
//        document.getElementById("message").innerText = "Error: " + error.message;
//        document.getElementById("message").classList.add("error");
//        document.getElementById("message").style.display = "block";
//    });
//});

// JavaScript file (example.js)
document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("registerForm");
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của form

        var formData = new FormData(form);

        fetch("/register", {
            method: "POST",
            body: JSON.stringify({
                username: formData.get('username'),
                password: formData.get('password')
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('Success:', data);
            // Chuyển hướng người dùng tới trang đăng nhập sau khi đăng ký thành công
            window.location.href = "/login";
        })
        .catch((error) => {
            console.error('Error:', error);
            // Hiển thị thông báo lỗi nếu có
        });
    });
});
