function doFirst(){
        checkPage = '${myPage}';
        checkTab ="#"+checkPage;
        checkPass ='${checkErr}';
       
        if (checkPage ==="contact"){
          $('#myinfo').html("");
          $('#contact').show()
          $('#contact').attr('class', "tab-pane fade active show")
          $('#myTabs a[href="#contact"]').tab('show')
          $("#home-tab").attr("class", 'nav-link')
          $("#contact-tab").attr('class', "nav-link active")
        }
        
        
      }
      window.addEventListener('load', doFirst);


    $(function(){
        $('#home-tab').click(function(){
          $('#contact').hide();
          $('#profile').hide();
          $('#myinfo').show();
          $('#myinfo').html("");
          $('#myinfo').load('memberPage/showmember.jsp');
          
          $('#editMemerinfo').click(function(){
              innerPage = "editMemerinfo";
             
              if(innerPage =="editMemerinfo"){
                 $('#myinfo').html("");
                 $('#myinfo').load('memberPage/editmember.jsp');
                 //alert(innerPage);
              }
              
            })
            
        
        $('#profile-tab').click(function(){
              $('#contact').hide();
              $('#profile').show();
              $('#myinfo').hide();
              //$('#myinfo').html("");
              //$('#myinfo').load('memberPage/showmember.jsp');
                });
        
        $('#contact-tab').click(function(){
              $('#contact').show();
              $('#profile').hide();
              $('#myinfo').hide();
              //$('#myinfo').html("");
              //$('#myinfo').load('memberPage/showmember.jsp');
                });
        
        
            })
});