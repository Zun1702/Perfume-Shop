/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function() {
    $('a.address_window').click(function() {
        var addressBox = $(this).attr('href');
        $(addressBox).fadeIn(300);
        $('body').append('<div id="over">');
        $('#over').fadeIn(300);
     
 });
 $(document).on('click', "a.close, #over", function() {
       $('#over, .address_box').fadeOut(300 , function() {
           $('#over').remove();
       });
  
 });
 
 $('a.add-address-window').click(function(){
     var addbox = $(this).attr('href');
     $(addbox).fadeIn(10);
 });
 

$(document).on('click', "a.back-to-address", function() {
       $(' .add_address_box').fadeOut(10 , function() {
       });
  
 });
 
 
 $("#myButton").click(function() {
    var newValue = $("input[name='radio_address']:checked").val(); // get the selected radio button value
    $.ajax({
      url: "checkout",
      type: "get",
      data: { newAddressID: newValue },
      success: function(response) {
        $("#myAttributeSpan").text(response);
      }
    });
  });
});

