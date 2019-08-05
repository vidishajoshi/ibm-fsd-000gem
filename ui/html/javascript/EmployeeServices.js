// HTML Events
const saveEmployee = () =>{
    console.log('Save Called');
    // create Employee Service Object
    const emp = new EmployeeService();
    emp.setup(
        document.getElementById('eId').value,
        document.getElementById('eName').value,
        document.getElementById('eEmail').value,
        document.getElementById('eDesignation').value
        );
    // SAVE Employee
    emp._add();
    fetchAllEmployees();
}

const fetchAllEmployees = ()=>{
    const emp = new EmployeeService();
    const employees = emp._all();
    buildEmployeeTable(employees);
    
}
// search
const searchEmployees = () =>{
    const emp = new EmployeeService();
    const employees = emp._filter(
                        document.getElementById('searchBy').value,
                        document.getElementById('criteria').value
                    );
    buildEmployeeTable(employees);
}
const buildEmployeeTable = (employees) =>{
    const empBody = document.getElementById('emp-details');
    let rows = '';
    employees.forEach((emp)=>{
        rows += `<tr>
                    <td>${emp.eId}</td>
                    <td>${emp.eName}</td>
                    <td>${emp.eEmail}</td>
                    <td>${emp.eDesignation}</td>
                    <td><a href='#' onclick="deleteEmployee('${emp.eEmail}')">Delete</a></td>
                    <td><a href='#' onclick="editEmployee('${emp.eEmail}')">Edit</a></td>
                </tr>`
    });
    empBody.innerHTML = rows;
    if(rows !=''){
        document.getElementById('tbl-employee').style.visibility = 'visible';
    }else{
        document.getElementById('tbl-employee').style.visibility = 'hidden';
    }
}

const asec = (v)=>{
    let sub=v;
    // console.log(sub);
    const emp=new EmployeeService();
    let data1 = emp._all();
    // console.log(data1);
    let emp_ = "";
    
    emp_ = data1.sort((p,n)=>{
        if(p[sub] > n[sub]){
            return 1;
        }else if(p[sub] < n[sub]){
            return -1;
        }else{
            return 0;
        }   
    });
    // console.log(emp_);
    buildEmployeeTable(emp_);
}

const desc = (w)=>{
    let sub1=w;
    const emp=new EmployeeService();
    let data1 = emp._all();
    // console.log(data1);
    let emp_ = "";
    emp_ = data1.sort((p,n)=>{
        if(p[sub1] > n[sub1]){
            return -1;
        }else if(p[sub1] < n[sub1]){
            return 1;
        }else{
            return 0;
        }   
    });
    // console.log(emp_);
    buildEmployeeTable(emp_);
}


const deleteEmployee = (eEmail)=>{
    const emp = new EmployeeService();
    emp._delete(eEmail);
    const emps = emp._all();
    buildEmployeeTable(emps);
}

const editEmployee = (eEmail) =>{
    const emp=new EmployeeService();
    let data = "";
    data=JSON.parse(localStorage.getItem(eEmail));
    //  console.log(JSON.stringify(data));
    document.getElementById('eId').value=data.eId;
    document.getElementById('eName').value=data.eName;
    document.getElementById('eEmail').value=data.eEmail;
    document.getElementById('eDesignation').value=data.eDesignation;
    //make email read only
    document.getElementById('eEmail').setAttribute('Readonly',true);
    document.getElementById('eId').focus();
    emp._delete('eEmail');
    
}
class EmployeeService {
    eId
    eName
    eEmail
    eDesignation

    // all argument constructor
    // setup method to configure attri
    setup(eId,eName,eEmail,eDesignation){
            this.eId = eId
            this.eName = eName
            this.eEmail = eEmail
            this.eDesignation = eDesignation
    }

    // CRUD Operations

    _all(){
        const employees = [];
        // fill up Array
        Object.keys(localStorage).forEach((storeKey)=>{
            employees.push(JSON.parse(localStorage.getItem(storeKey)));
        });
        return employees;
    }
    _filter(searchBy, criteria){
        let employees = [];
        // fill up Array
            if(criteria !=null && searchBy == 'ID'){
                    Object.keys(localStorage).forEach((e)=>{
                        const _emp = JSON.parse(localStorage.getItem(e));
                        if(_emp.eId == criteria){
                            employees.push(_emp);
                        }
                    });
                }
                else if(criteria !=null && searchBy == 'DESIG'){
                        Object.keys(localStorage).forEach((e)=>{
                            const _emp = JSON.parse(localStorage.getItem(e));
                            if(_emp.eDesignation == criteria){
                                employees.push(_emp);
                            }
                       });
            }
        return employees;
    }
    _add(){
        localStorage.setItem(this.eEmail,JSON.stringify({
            eId : this.eId,
            eName: this.eName,
            eEmail: this.eEmail,
            eDesignation: this.eDesignation
        }));
    }
    _update(){

    }
    _delete(eEmail){
        localStorage.removeItem(eEmail);
    }
}