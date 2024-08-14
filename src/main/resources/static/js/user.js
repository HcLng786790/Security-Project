document.addEventListener("DOMContentLoaded", function() {
    const apiEndpoint = `http://localhost:8082/user/api/profile`;

    fetch(apiEndpoint)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            // Hiển thị thông tin người dùng lên giao diện
            document.getElementById("username").value = data.username;
            document.getElementById("name").value = data.name;
            document.getElementById("email").value = data.email;
            document.getElementById("company").value = data.company;
            document.getElementById('bio').value = data.userInfoResponseDTO.bio;
            document.getElementById('birthday').value = data.userInfoResponseDTO.birthday;
            document.getElementById('country').value = data.userInfoResponseDTO.country;
            document.getElementById('phone').value = data.userInfoResponseDTO.phone;
            document.getElementById('website').value = data.userInfoResponseDTO.website;

            document.getElementById('twitter').value = data.userSocialResponseDTO.twitter;
            document.getElementById('facebook').value = data.userSocialResponseDTO.facebook;
            document.getElementById('google').value = data.userSocialResponseDTO.google;
            document.getElementById('linkedIn').value = data.userSocialResponseDTO.linkedIn;
            document.getElementById('instagram').value = data.userSocialResponseDTO.instagram;
            // Nếu có avatar URL trong dữ liệu trả về
            if (data.avatarUrl) {
                document.getElementById("user-avatar").src = data.avatarUrl;
            }
            console.log(data);
        })
        .catch(error => console.error("Error fetching user data:", error));
});
