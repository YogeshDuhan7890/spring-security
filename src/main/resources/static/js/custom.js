$('.owl-carousel').owlCarousel({
        items: 5,
        loop: true,
        margin: 15,
        autoplay: true,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:3
            },
            1000:{
                items:3
            }
        }
    })

    $(function() {
        $('.vticker').vTicker();
        });
    $(function() {
        $('.vticker').vTicker({
        speed: 700,
        pause: 4000,
        showItems: 3,
        mousePause: true,
        height: 0,
        animate: true,
        margin: 2,
        padding: 0,
        startPaused: false});
        });
    