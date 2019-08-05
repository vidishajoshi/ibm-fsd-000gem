const loadEmployees= ()=>{
    let rows = '';
    // traverse the array
    emps.forEach((employee) =>{
        rows += empRow(employee);
    });
    empTable(rows);
}

const empRow=(employee)=>{
    return `<tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.organization}</td>
    </tr> `
};

empTable = (rows) =>{       
    let records = `<table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Organization</th>
                    </tr>
                    ${rows}    
                </table>`;
    document.getElementById('div-emps').innerHTML = records;    
}

const filterEmps1= () =>{
    const obj7 = new EmployeeService();
    obj7.filterEmps();
    //console.log('test');
}

class EmployeeService{
    emps = [
       {
         id : 1,
         name : 'Ram',
         email: 'ram@gg.com',
         organization: 'IBM'
       },
       {
         id : 2,
         name : 'Shyam',
         email: 'shyam@gg.com',
         organization: 'IBM'
       },
       {
         id : 3,
         name : 'Gabbar',
         email: 'gabbar@gg.com',
         organization: 'CTS'
       }
    ];
             
    filterEmps(){
       let rows = '';
       searchByOrg = document.getElementById('search').value;
 
       emps.filter((emp)=>{
           return emp.organization == searchByOrg;
        }).forEach((employee)=>{
           rows += this.empRow(employee);
        });
        this.empTable(rows);
    }

    empRow(empl){
        return `<tr>
            <td>${empl.id}</td>
            <td>${empl.name}</td>
            <td>${empl.email}</td>
            <td>${empl.organization}</td>
        </tr> `
    }
 
    empTable(rows){
        let records = `<table>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Organization</th>
                        </tr>
                        ${rows}    
                    </table>`;
        document.getElementById('div-emps').innerHTML = records;    
 }
 
}
 
 
 /*const empRow = (employee)=>{
     return `<tr>
         <td>${employee.id}</td>
         <td>${employee.name}</td>
         <td>${employee.email}</td>
         <td>${employee.organization}</td>
     </tr> `
 }
 const empTable = (rows)=>{
      let records = `<table>
                     <tr>
                         <th>Id</th>
                         <th>Name</th>
                         <th>Email</th>
                         <th>Organization</th>
                     </tr>
                     ${rows}    
                 </table>`;
     document.getElementById('div-emps').innerHTML = records;
 }
 const findById = () =>{
     const empId = document.getElementById('findById').value;
     
     const empFound = emps.find((e)=>{
                         return empId == e.id;
                  });
     if(empFound != undefined){
         alert(empFound.id+' '+empFound.name);
     }else{
         alert('No Employees Found with the given Criteria');
     }
 }
 function saveLocalStorage(){
     let rows = '';
     emps.forEach((employee) =>{
         rows += empRow(employee);
     })
     localStorage.setItem('data',rows);
     
 //    localStorage.setItem('message',"how are you");
     }
     const viewwebstore = () =>{
         if (localStorage.length>0){
             Object.keys(localStorage).forEach(key=>{
                 console.log(localStorage.getItem())
             })
         }
     }
  
 function addEmp(){
     savelocalStorage();
     let newRo = localStorage.getItem('data',rows);
     console.log(newRo);
     
     let id_e = document.getElementById('e_id').value;
     let name_e = document.getElementById('e_name').value;
     let email_e = document.getElementById('e_email').value;
     let org_e = document.getElementById('e_org').value;
     console.log(`${id_e},${name_e},${email_e},${org_e}`);
     let newR = `<tr>
         <td>${id_e}</td>
         <td>${name_e}</td>
         <td>${email_e}</td>
         <td>${org_e}</td>
     </tr> `;
 
  
      
      empTable(newR);
      console.log(empTable);
 
 
 }*/