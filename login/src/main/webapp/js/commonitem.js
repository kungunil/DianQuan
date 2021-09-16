let itemid;
let cmtbtn = document.querySelector("#comment span");
let form = document.querySelector("form");
let fileinput = document.querySelector("#imgfile");

window.addEventListener("load", docinit);
fileinput.addEventListener("change", function(e) {
  let file = e.target.files[0];
  let imgbackshow = document.querySelector('.imgbackshow');
  let img = document.querySelector(".imgbackshow img");

  img.src = URL.createObjectURL(file);
  imgbackshow.style.display = "block";
});
cmtbtn.addEventListener("click", function (e) {
  let area = document.querySelector(".commentinput");
  if (area.style.display == "") {
    area.style.display = "block";
    document.querySelector("#cmttext").focus();
  } else {
    area.style.display = "";
  }
});
form.addEventListener("submit", function (e) {
  e.preventDefault();
  e.stopPropagation();
  let formdata = new FormData(e.target);
  formdata.append("itemid", itemid);
  let init = {
    method: "post",
    body: formdata,
  };

  fetch("../upload", init)
    .then(function (respond) {
      return respond.json();
    })
    .then(function (json) {
      if (json["returninfo"] == "ok") {
        alert("发表成功");
        location.reload();
      } else {
        alert("错误，发表失败");
      }
    });
});

//关注用户
function followuserlistener(markico) {
  markico.addEventListener("click", function(e) {
    e.preventDefault();
    e.stopPropagation();
    fetch(e.target.parentElement.href)
    .then(function(respond) {
      return respond.json();
    })
    .then(function(json) {
      if (json["returninfo"] == "ok") {
        let oldhref = e.target.parentElement.href;
        let oldsrc = e.target.src;
        if (e.target.src.substring(oldsrc.lastIndexOf("/")+1, oldsrc.lastIndexOf(".")) == "mark") {
          e.target.src = "../image/marked.svg";
          e.target.parentElement.href = `${oldhref.substring(0, oldhref.length-1)}2`;
        } else {
          e.target.src = "../image/mark.svg";
          e.target.parentElement.href = `${oldhref.substring(0, oldhref.length-1)}1`;
        }
        location.reload();
      } else {
        alert("错误，关注失败");
      }
    });
  });
}
//收藏点评
function collectlistener(collectico) {
  collectico.addEventListener("click", function(e) {
    e.preventDefault();
    e.stopPropagation();
    fetch(e.target.parentElement.href)
    .then(function(respond) {
      return respond.json();
    })
    .then(function(json) {
      if (json["returninfo"] == "ok") {
        let oldhref = e.target.parentElement.href;
        let oldsrc = e.target.src;
        if (e.target.src.substring(oldsrc.lastIndexOf("/")+1, oldsrc.lastIndexOf(".")) == "collect") {
          e.target.src = "../image/collected.svg";
          e.target.parentElement.href = `${oldhref.substring(0, oldhref.length-1)}2`;
        } else {
          e.target.src = "../image/collect.svg";
          e.target.parentElement.href = `${oldhref.substring(0, oldhref.length-1)}1`;
        }
        location.reload();
      } else {
        alert("错误，收藏失败");
      }
    });
  });
}


//初始化
function docinit() {
  let itemname = location.pathname.substring(location.pathname.lastIndexOf("/")+1);
  fetch(`../iteminfo?itemname=${itemname}`)
    .then(function (respond) {
      return respond.json();
    })
    .then(function(json) {
      if (json.uid) {
        infoshowuser(json, parseInt(json.uid));
      }
      else {
        infoshowNouser(json);
      }
    });
  function infoshowNouser(myjson) {
    itemid = myjson["item"]["itemid"];
    let itemname = document.querySelector(".title h2");
    let usernames = document.querySelectorAll(".usrcmt h3");
    let commentviews = document.querySelectorAll(".commentview");
    let iteminfo = document.querySelector("#info");

    itemname.textContent = myjson["item"]["itemname"];
    iteminfo.textContent = myjson["item"]["iteminfo"];
    for (let i = 0; i < myjson["uac"].length; i++) {
      let uac = myjson["uac"][i];
      usernames[i].textContent = uac["username"];
      commentviews[i].textContent = uac["comment"];
      if (uac["imgname"]) {
        let image = document.createElement("img");
        image.src = `../uploadimg/${uac["imgname"]}`;
        image.alt = "评论图片";
        commentviews[i].append(image);
      }
    }
  }

  function infoshowuser(myjson, uid) {
    infoshowNouser(myjson);
    update(myjson);

    async function update(myjson) {
      let fetchurl = `../iteminfo?itemname=${itemname}&uid=${uid}`;
      let json = await fetch(fetchurl)
      .then(function(respond) {
        return respond.json();
      });
      let attention = json.attention.split(",");
      let collection = json.collection.split(",");
      let username = document.querySelector("#loginplace");
      let markicos = document.querySelectorAll(".markico");
      let collecticos = document.querySelectorAll(".collectico");
      let informanticos = document.querySelectorAll(".informant");
      
      username.firstElementChild.textContent = json.username;
      username.firstElementChild.href = `../usercenter`; //用户中心链接
      for (let i = 0; i < myjson["uac"].length; i++) {
        let uac = myjson["uac"][i];
        //为关注、收藏按钮添加监听器，举报按钮点击跳转到举报中心
        followuserlistener(markicos[i]);
        collectlistener(collecticos[i]);

        informanticos[i].parentElement.href = `../informant?cmtid=${uac.cmtid}`; //举报链接
        if (attention.includes(`${uac.uid}`)) {
          markicos[i].src = "../image/marked.svg";
          markicos[i].parentElement.href = `../fav?wt=user&id=${uac.uid}&type=2`;
        } else {
          markicos[i].src = "../image/mark.svg";
          markicos[i].parentElement.href = `../fav?wt=user&id=${uac.uid}&type=1`;
        }
        if (collection.includes(`${uac.cmtid}`)) {
          collecticos[i].src = "../image/collected.svg";
          collecticos[i].parentElement.href = `../fav?wt=collect&id=${uac.cmtid}&type=2`;
        } else {
          collecticos[i].src = "../image/collect.svg";
          collecticos[i].parentElement.href = `../fav?wt=collect&id=${uac.cmtid}&type=1`;
        }
      } 
    }
  }
}