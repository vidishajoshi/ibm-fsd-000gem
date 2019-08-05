  function registerTrainer() {
      //Accessing variable from the html
      let t_name = document.getElementById('t_id').value;
      let t_1 = document.getElementById('t1');
      let t_2 = document.getElementById('t2');
      let t_3 = document.getElementById('t3');
      let t_4 = document.getElementById('t4');
      let t_5 = document.getElementById('t5');
      let t_6 = document.getElementById('t6');

      //condition checked and storing value according the time
      //9 am
      if (t_1.checked) {
          if (localStorage.getItem(t_1.value) == undefined) {
              localStorage.setItem(t_1.value, t_name);
          } else {
              let okd = localStorage.getItem(t_1.value);
              localStorage.setItem(t_1.value, okd + ',' + t_name);
              console.log(localStorage.getItem(t_1.value));
          }
      }


      //10 am
      if (t_2.checked) {
          if (localStorage.getItem(t_2.value) == undefined) {
              localStorage.setItem(t_2.value, t_name);
          } else {
              let okd = localStorage.getItem(t_2.value);
              localStorage.setItem(t_2.value, okd + ',' + t_name);
              console.log(localStorage.getItem(t_2.value));
          }
      }

      //11 am
      if (t_3.checked) {
          if (localStorage.getItem(t_3.value) == undefined) {
              localStorage.setItem(t_3.value, t_name);
          } else {
              let okd = localStorage.getItem(t_3.value);
              localStorage.setItem(t_3.value, okd + ',' + t_name);
              console.log(localStorage.getItem(t_3.value));
          }
      }

      //12 pm
      if (t_4.checked) {
          if (localStorage.getItem(t_4.value) == undefined) {
              localStorage.setItem(t_4.value, t_name);
          } else {
              let okd = localStorage.getItem(t_4.value);
              localStorage.setItem(t_4.value, okd + ',' + t_name);
              console.log(localStorage.getItem(t_4.value));
          }
      }

      //1 pm
      if (t_5.checked) {
          if (localStorage.getItem(t_5.value) == undefined) {
              localStorage.setItem(t_5.value, JSON.stringify(t_name));
              let d = localStorage.getItem(t_5.value);
              console.log(t_5.value, d);
          } else {
              let okd = localStorage.getItem(t_5.value);
              localStorage.setItem(t_5.value, okd + ',' + t_name);
              console.log(okd[1]);
              console.log(localStorage.getItem(t_5.value));
          }

          //2pm
      }
      if (t_6.checked) {
          if (localStorage.getItem(t_6.value) == undefined) {
              localStorage.setItem(t_6.value, t_name);
          } else {
              let okd = localStorage.getItem(t_6.value);
              localStorage.setItem(t_6.value, okd + ',' + t_name);
              console.log(localStorage.getItem(t_6.value));
          }
      }


      //accessing subject details from html
      let s_1 = document.getElementById('eng');
      let s_2 = document.getElementById('math');
      let s_3 = document.getElementById('hindi');
      let s_4 = document.getElementById('sst');
      let s_5 = document.getElementById('science');
      let s_6 = document.getElementById('sports');
      //condition checked and storing value according the subjects
      //9 am
      if (s_1.checked) {
          if (localStorage.getItem(s_1.value) == undefined) {
              localStorage.setItem(s_1.value, t_name);
          } else {
              let okd = localStorage.getItem(s_1.value);
              localStorage.setItem(s_1.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_1.value));
          }
      }


      //10 am
      if (s_2.checked) {
          if (localStorage.getItem(s_2.value) == undefined) {
              localStorage.setItem(s_2.value, t_name);
          } else {
              let okd = localStorage.getItem(s_2.value);
              localStorage.setItem(s_2.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_2.value));
          }
      }

      //11 am
      if (s_3.checked) {
          if (localStorage.getItem(s_3.value) == undefined) {
              localStorage.setItem(s_3.value, t_name);
          } else {
              let okd = localStorage.getItem(s_3.value);
              localStorage.setItem(s_3.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_3.value));
          }
      }

      //12 pm
      if (s_4.checked) {
          if (localStorage.getItem(s_4.value) == undefined) {
              localStorage.setItem(s_4.value, t_name);
          } else {
              let okd = localStorage.getItem(s_4.value);
              localStorage.setItem(s_4.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_4.value));
          }
      }

      //1 pm
      if (s_5.checked) {
          if (localStorage.getItem(s_5.value) == undefined) {
              localStorage.setItem(s_5.value, t_name);
          } else {
              let okd = localStorage.getItem(s_5.value);
              localStorage.setItem(s_5.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_5.value));
          }

          //2pm
      }
      if (s_6.checked) {
          if (localStorage.getItem(s_6.value) == undefined) {
              localStorage.setItem(s_6.value, t_name);
          } else {
              let okd = localStorage.getItem(s_6.value);
              localStorage.setItem(s_6.value, okd + ',' + t_name);
              console.log(localStorage.getItem(s_6.value));
          }
      }
  }


  function gen_time() {
      let sub_ = document.getElementById('sub').value;
      let time_ = document.getElementById('time_t').value;

      //   console.log(sub_ + ',' + time_);

      let subject = localStorage.getItem(sub_);
      let time_t1 = localStorage.getItem(time_);
      let class_select = localStorage.getItem(class_s);

      if (subject == time_t1) {
          console.log(localStorage.getItem(subject));

      }
  }