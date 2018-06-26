/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    carrega();
    $("#btnEnviar").click(function(){   
       
            localStorage.clear();
        });
  });
  
  function carrega(){
      var tbProdutos = localStorage.getItem("tbProdutos");
      tbProdutos = JSON.parse(tbProdutos);
      var linha = "<thead><tr><th>ID</th><th>Nome</th><th>Preço</th><th>Ações</th></tr></thead>";
      
      var ptotal = 0;
      for(i = 0 ; i < tbProdutos.length ; i++){
          linha = linha+"<tr><td><input type='text' value="+tbProdutos[i]['proid']+" readonly='readonly' name='tfId"+(i)+"' hidden/>"+tbProdutos[i]['proid']+"</td><td>"+tbProdutos[i]['pronome']+"</td><td><input name='tfPreco"+(i)+"' class='form-control' value='R$"+tbProdutos[i]['propreco']+"' type='text'/ readonly='readonly'></td>";
      	linha = linha+"<td><a href='#' class='btn btn-primary'>Detalhe</a></td><td><a href='#'id="+(i)+" class='btn btn-danger'  onClick='excluir(this)'>X</a></td></tr>";
      	ptotal = ptotal + tbProdutos[i]['propreco'];
      }
      linha = linha + "<tr><td>Quantidade</td><td><input name='tfQtde' class='form-control' type='text' value="+tbProdutos.length+" readonly='readonly'/></td>";
      linha = linha + "<td>P.Total</td><td><input type='text' class='form-control' name='tfTotal' value='R$"+ptotal+"' readonly='readonly'/></td></tr>";
      $("#produtos").html(linha);
  }


 function excluir(atributo){
        var id = $(atributo).attr("id");        
        var index = parseInt(id);
        var tbProdutos = localStorage.getItem("tbProdutos");
        tbProdutos = JSON.parse(tbProdutos);
        
 	 tbProdutos.splice(index,1);
         localStorage.clear();
         
         localStorage.setItem("tbProdutos",JSON.stringify(tbProdutos));
         
         carrega();
 }


