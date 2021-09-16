window.addEventListener("load", itemshow);

function itemshow() {
    fetch("./home/inforefresh")
    .then(function(respond) {
        return respond.json();
    })
    .then(function(json) {
        let itemnames = document.querySelectorAll(".itemname");
        let iteminfos = document.querySelectorAll(".iteminfo");
        let loginplace = document.querySelector("#loginplace");

        for (let i = 0; i < json.items.length; i++) {
            let item = json.items[i];
            itemnames[i].textContent = item.itemname;
            itemnames[i].href = `./item/${item.itemname}`;
            iteminfos[i].textContent = item.iteminfo;
        }
        if (json.user) {
            if (json.user.type == 2) {
                loginplace.firstElementChild.textContent = json.user.username;
                loginplace.firstElementChild.href = "./usercenter" //用户中心链接
            }
            else if (json.user.type == 1) {
                loginplace.firstElementChild.textContent = "管理中心";
                loginplace.firstElementChild.href = `./applyServlet?action=page`;
            }
        }
    });
}