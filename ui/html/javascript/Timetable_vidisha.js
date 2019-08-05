let sub_map = new Map();

function _addTrainer() {
    let t_name = document.getElementById('tname').value;
    let t_sub = document.getElementById('tsub').value;
    console.log("" + t_name + " : " + t_sub);
    localStorage.setItem('t_name', t_name);
    localStorage.setItem('t_sub', t_sub);
    show_trainer();

}

function show_trainer() {
    let trainer = localStorage.getItem('t_name');
    console.log(trainer);
    let dropd = `<option value='${trainer}'>${trainer}</option>`;
    document.getElementById('op').innerHTML = dropd;
}

function assign_sub(var1, var2) {
    sub_ = document.getElementById('su').value;
    train_ = document.getElementById('op').value;
    console.log(sub_)

    localStorage.setItem('subject', sub_);
    localStorage.setItem('trainer', train_);


    sub_map.set(sub_, train_);
    // console.log(sub_map.get(sub_));

}
const arr = '';
for (let item of sub_map.entries()) {
    arr = item;
}

function show_Data() {
    for (let item of sub_map.entries()) {
        console.log(`${key},${value}`);
    }
}

function create_table() {
    const empBody = document.getElementById('emp-details');

    let rows = '';
    arr.forEach((emp) => {
        rows += `<tr>
                    <td>${show_Data()}
                    }</td>
                    </tr>
                    `;
    });

    empBody.innerHTML = rows;

}