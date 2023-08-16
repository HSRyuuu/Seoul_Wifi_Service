function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            //빈칸에 값 넣기
            document.getElementById("lat").value = latitude;
            document.getElementById("lnt").value = longitude;
        });
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}