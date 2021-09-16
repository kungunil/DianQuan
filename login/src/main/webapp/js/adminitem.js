window.addEventListener("load", docinit);

function docinit() {
  let itemname = location.pathname.slice(15);
  fetch(`../iteminfo?itemname=${itemname}`)
    .then(function (respond) {
      return respond.json();
    })
    .then(function(json) {
      infoshow(json);
    });
  function infoshow(myjson) {
    itemid = myjson["item"]["itemid"];
    let itemname = document.querySelector(".title h2");
    let usernames = document.querySelectorAll(".usrcmt h3");
    let commentviews = document.querySelectorAll(".commentview");
    let iteminfo = document.querySelector("#info");
    let loginplace = document.querySelector("#loginplace");
    let recmditem = document.querySelector(".recmditem");
    let recmdcmt = document.querySelectorAll(".recmdcmt");

    loginplace.firstElementChild.textContent = "管理中心";
    loginplace.firstElementChild.href = `../applyServlet?action=page`;
    recmditem.href = `../rcm?type=1&id=${myjson["item"]["itemid"]}`;
    rcmlistener(recmditem);
    itemname.textContent = myjson["item"]["itemname"];
    iteminfo.textContent = myjson["item"]["iteminfo"];
    for (let i = 0; i < myjson["uac"].length; i++) {
      let uac = myjson["uac"][i];
      usernames[i].textContent = uac["username"];
      commentviews[i].textContent = uac["comment"];
      recmdcmt[i].href = `../rcm?type=2&id=${uac["cmtid"]}`;
      rcmlistener(recmdcmt[i]);
      if (uac["imgname"]) {
        let image = document.createElement("img");
        image.src = `../uploadimg/${uac["imgname"]}`;
        image.alt = "评论图片";
        commentviews[i].append(image);
      }
    }
  }
}

function rcmlistener(recmd) {
  recmd.addEventListener("click", function(e) {
    e.preventDefault();
    e.stopPropagation();
    fetch(e.target.href)
    .then(function(respond) {
      return respond.json();
    })
    .then(function(json) {
      if (json["returninfo"] == "ok") {
        alert("推荐成功");
      } else {
        alert("错误，推荐失败");
      }
    });
  });
}