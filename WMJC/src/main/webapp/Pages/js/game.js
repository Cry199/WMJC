$(".custom-carousel").owlCarousel({
    autoWidth: true,
    loop: true,
    onInitialized: function(event) {
        $(".custom-carousel .owl-item").click(function () {
            $(".custom-carousel .owl-item").removeClass("active");
            $(this).addClass("active");
        });
    }
});
