document.querySelector(".hamburger").addEventListener("click", function () {
    document.querySelector(".menu_bar_links").classList.toggle("active");
  });
  
  window.addEventListener("click", function (event) {
    if (
      !event.target.closest(".menu_bar") &&
      !event.target.closest(".hamburger")
    ) {
      document.querySelector(".menu_bar_links").classList.remove("active");
    }
  });
  document.querySelectorAll(".nav_links a").forEach(function (link) {
    link.addEventListener("click", function () {
      document.querySelector(".menu_bar_links").classList.remove("active");
    });
  });  