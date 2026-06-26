var v_id = 4;
var v_idUpdate = -1; // lưu lại id đang upadte
var arrs = [
    {
        id: 1,
        username: "nguyenvana",
        fullName: "Nguyễn Văn A",
        age: 20,
    },
    {
        id: 2,
        username: "tranvanb",
        fullName: "Trần Văn B",
        age: 30,
    },
    {
        id: 3,
        username: "ngothic",
        fullName: "Ngô Thị C",
        age: 25,
    },
    {
        id: 4,
        username: "levand",
        fullName: "Lê Văn D",
        age: 21,
    },
];
loadData();

function loadData() {
    var tableContent = "";
    for (let i = 0; i < arrs.length; i++) {
        tableContent += "<tr>";
        tableContent += "<td>" + arrs[i].id + "</td>";
        tableContent += "<td>" + arrs[i].username + "</td>";
        tableContent += "<td>" + arrs[i].fullName + "</td>";
        tableContent += "<td>" + arrs[i].age + "</td>";
        tableContent +=
            "<td><button onclick='onHandleUpdate(" + arrs[i].id + ")'>Edit</button> " + " <button onclick='onDelete(" + arrs[i].id + ")'>Delete</button></td>";
        tableContent += "</tr>";
    }
    // trước khi show data thì clear bảng trước
    //jqEmpty
    $("#tableBoby").empty();
    // jqAppend
    $("#tableBoby").append(tableContent);
}

function onDelete(idDelete) {
    var comfirm = confirm("Bạn có chắc chắn xóa account này không?");
    if (comfirm == true) {
        var indexDelete = -1;
        for (let i = 0; i < arrs.length; i++) {
            if (arrs[i].id == idDelete) {
                indexDelete = i;
                break;
            }
        }
        arrs.splice(indexDelete, 1); // xóa ptu theo vị trí, số lượng ptu muốn xóa
        alert("Xóa thành công");
        loadData(); // hiển thị lại ds
    }
}

// jqSubmit
$("#accountForm").submit(function (e) {
    e.preventDefault();
    if (v_idUpdate > 0) {
        alert("Đang update, ko thể tạo mới dc");
        return;
    }

    var v_username = $("#inputUsername").val();
    var v_fullName = $("#inputFullname").val();
    var v_age = $("#inputAge").val();

    // đưa các dữ liệu trên vào object và thêm vào arrs
    var account = {
        id: ++v_id,
        username: v_username,
        fullName: v_fullName,
        age: v_age,
    };
    arrs.push(account);
    alert("Thêm dữ liệu thành công");
    // hiển thị lại ds account
    loadData();
    // clear dữ lieu 3 ô username, fullName, age ở tren
    //jqValSet
    $("#inputUsername").val("");
    $("#inputFullname").val("");
    $("#inputAge").val("");
});

function onHandleUpdate(idUpdate) {
    // dua vào id de show dũ lieu len cac o input
    for (let i = 0; i < arrs.length; i++) {
        if (arrs[i].id == idUpdate) {
            // hien thi du lieu len
            $("#inputUsername").val(arrs[i].username);
            $("#inputFullname").val(arrs[i].fullName);
            $("#inputAge").val(arrs[i].age);
            v_idUpdate = idUpdate; // lưu lại id cần update
            break;
        }
    }
    // disabled nút create đi
    // $("#btnCreate").prop("disabled", true);
}

$("#btnUpdate").click(function (e) {
    var v_username = $("#inputUsername").val();
    var v_fullName = $("#inputFullname").val();
    var v_age = $("#inputAge").val();
    // tìm vị tri của object cần update trong mảng
    var v_indexUpdate = -1;
    // for (let i = 0; i < arrs.length; i++) {
    //     if (arrs[i].id == v_idUpdate) {
    //         v_indexUpdate = i;
    //         break;
    //     }
    // }
    v_indexUpdate = arrs.findIndex((i) => i.id == v_idUpdate);
    // update gtri ở vị trí thứ i = gtri nhạp từ màn hình
    if (v_idUpdate == -1) {
        alert("Ptu này ko tồn tại, hoặc đang tạo mới");
    } else {
        arrs[v_indexUpdate] = {
            id: v_idUpdate,
            username: v_username,
            fullName: v_fullName,
            age: v_age,
        };
        alert("Update dữ liệu thành công");
        // hiển thi ls account
        loadData();
        // clear dữ lieu 3 ô username, fullName, age ở tren
        //jqValSet
        v_idUpdate = -1;
        $("#inputUsername").val("");
        $("#inputFullname").val("");
        $("#inputAge").val("");
    }
});

// function onUpdateAccount() {
//     var v_username = $("#inputUsername").val();
//     var v_fullName = $("#inputFullname").val();
//     var v_age = $("#inputAge").val();
//     // tìm vị tri của object cần update trong mảng
//     var v_indexUpdate = -1;
//     // for (let i = 0; i < arrs.length; i++) {
//     //     if (arrs[i].id == v_idUpdate) {
//     //         v_indexUpdate = i;
//     //         break;
//     //     }
//     // }
//     v_indexUpdate = arrs.findIndex((i) => i.id == v_idUpdate);
//     // update gtri ở vị trí thứ i = gtri nhạp từ màn hình
//     if (v_idUpdate == -1) {
//         alert("Ptu này ko tồn tại, hoặc đang tạo mới");
//     } else {
//         arrs[v_indexUpdate] = {
//             id: v_idUpdate,
//             username: v_username,
//             fullName: v_fullName,
//             age: v_age,
//         };
//         alert("Update dữ liệu thành công");
//         // hiển thi ls account
//         loadData();
//         // clear dữ lieu 3 ô username, fullName, age ở tren
//         //jqValSet
//         v_idUpdate = -1;
//         $("#inputUsername").val("");
//         $("#inputFullname").val("");
//         $("#inputAge").val("");
//     }
// }
