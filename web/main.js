var arr_img = [
    "https://theme.hstatic.net/200000374707/1000984519/14/slideshow_2.jpg?v=51",
    "https://theme.hstatic.net/200000374707/1000984519/14/slideshow_1.jpg?v=51"
];
var index = 0;
function next()
{
    index++;
    if (index >= arr_img.length)
        index = 0;
    var img__bgreview = document.getElementById("img__bgreview");
    img__bgreview.src = arr_img[index];
}
function prev()
{
    index--;
    if (index < 0)
        index = 2;
    var img__bgreview = document.getElementById("img__bgreview");
    img__bgreview.src = arr_img[index];
}
setInterval(next, 3000);
// Hiệu ứng chọn ảnh nhỏ mở ra ảnh lớn trong phần sản phẩm-products
var img_products = [
    "../assets/img/Uchiha Madara (2).jpg",
    "../assets/img/Uchiha Madara (1).jpg",
    "../assets/img/Uchiha Madara (3).jpg",
    "../assets/img/Uchiha Madara (4).jpg",
    "../assets/img/Uchiha Madara (5).jpg",
]



// Nextimg_products = function next_img_products()
// {
//     dem++;
//     if(dem >= img_products.length)
//         dem = 0;
//     var img__bgreview = document.getElementById("img_products_big");
//     img__bgreview.src = img_products[dem];
// }
// setInterval(Nextimg_products,3000);

// mở form đăng kí
function op_register() {
    let register = document.getElementById("createacc");
    register.style.display = "block";

    let login = document.getElementById("login");
    login.style.display = "none";

    let btnlogin = document.getElementById("btn_login")
    btnlogin.style.display = "block";

    let btnregister = document.getElementById("btn_createaccount");
    btnregister.style.display = "none";
}

function op_login() {
    let register = document.getElementById("createacc");
    register.style.display = "none";

    let login = document.getElementById("login");
    login.style.display = "block";

    let btnlogin = document.getElementById("btn_login")
    btnlogin.style.display = "none";

    let btnregister = document.getElementById("btn_createaccount");
    btnregister.style.display = "block";
}

// Chuyển đổi tab nhận xét và mô tả trong products-sản phẩm
function op_detail() {
    let comment = document.getElementById("products-item-cmt");
    comment.style.border = "none";

    let detail = document.getElementById("products-item-detail");
    detail.style.border = "solid 1px #72af5c";

    let comment_content = document.getElementById("product_contentcomment");
    comment_content.style.display = "none";

    let detail_content = document.getElementById("product_contentdetail");
    detail_content.style.display = "block";
}

function op_comment() {
    let comment = document.getElementById("products-item-cmt");
    comment.style.border = "solid 1px #72af5c";

    let detail = document.getElementById("products-item-detail");
    detail.style.border = "none";

    let comment_content = document.getElementById("product_contentcomment");
    comment_content.style.display = "block";

    let detail_content = document.getElementById("product_contentdetail");
    detail_content.style.display = "none";
}