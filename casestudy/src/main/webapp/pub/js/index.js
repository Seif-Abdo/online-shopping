const logo = document.getElementById("logo")

logo.addEventListener("mouseover", () => {
    logo.style.transform = "rotate(180deg)"

})

logo.addEventListener("mouseout", () => {
    logo.style.transform = "rotate(360deg)"
})