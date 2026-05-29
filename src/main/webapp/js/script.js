/* Homepage Slideshow */

let slides = document.querySelectorAll(".slide");

let currentSlide = 0;

function showSlide() {

    slides.forEach(function(slide){
        slide.classList.remove("active");
    });

    slides[currentSlide].classList.add("active");

    currentSlide++;

    if(currentSlide >= slides.length){
        currentSlide = 0;
    }
}

showSlide();

setInterval(showSlide,3000);

/* Brand Slideshow */
let brandSlides = document.querySelectorAll(".brand-slide");

let brandIndex = 0;

function showBrandSlide(){

    if(brandSlides.length > 0){

        brandSlides.forEach(function(slide){
            slide.classList.remove("active");
        });

        brandSlides[brandIndex].classList.add("active");

        brandIndex++;

        if(brandIndex >= brandSlides.length){
            brandIndex = 0;
        }
    }
}

showBrandSlide();

setInterval(showBrandSlide,3000);