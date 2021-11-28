$(document).ready(function() {
    $('.btn.btn-primary.btn-lg').on('click', function() {

        var button = $(this);
        var cart = $('#cart-icon');

        setTimeout(function() {
            cart.addClass('shake');
            setTimeout(function() {
                cart.removeClass('shake');
            }, 500)
        }, 0)
    })
})