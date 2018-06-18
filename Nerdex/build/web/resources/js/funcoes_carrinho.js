/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
	  var tbProdutos = localStorage.getItem("tbProdutos");
      tbProdutos = JSON.parse(tbProdutos);
      var linha = "<thead><tr><th>ID</th><th>Nome</th><th>Preço</th><th>Ações</th></tr></thead>";
      
      var ptotal = 0;


      for(i = 0 ; i < tbProdutos.length ; i++){
      	linha = linha+"<tr><td>"+tbProdutos[i]['proid']+"</td><td>"+tbProdutos[i]['pronome']+"</td><td>"+tbProdutos[i]['propreco']+"</td>";
      	linha = linha+"<td><a href='#' class='btn btn-primary'>Detalhe</a></td><td><a href='#' class='btn btn-danger' onclick='excluir(i)'>X</a></td></tr>";
      	ptotal = ptotal + tbProdutos[i]['propreco'];
      }
      linha = linha + "<tr><td>Quantidade</td><td><input name='tfQtde' class='form-control' type='text' value="+tbProdutos.length+" readonly='readonly'/></td>";
      linha = linha + "<td>P.Total</td><td>R$"+ptotal+"</td></tr>";
      $("#produtos").html(linha);

  });
 
 
 function excluir(index){
 	 var tbProdutos = localStorage.getItem("tbProdutos");
         tbProdutos = JSON.parse(tbProdutos);
         tbProdutos.splice(index,2);
         localStorage.setItem("tbProdutos",JSON.stringify(tbProdutos));
         
         var linha = "<thead><tr><th>ID</th><th>Nome</th><th>Preço</th><th>Ações</th></tr></thead>";
		 var ptotal = 0;
	    for(i = 0 ; i < tbProdutos.length ; i++){
	      	linha = linha+"<tr><td>"+tbProdutos[i]['proid']+"</td><td>"+tbProdutos[i]['pronome']+"</td><td>"+tbProdutos[i]['propreco']+"</td>";
	      	linha = linha+"<td><a href='#' class='btn btn-primary'>Detalhe</a></td><td><a href='#' class='btn btn-danger' onclick='excluir(i)'>X</a></td></tr>";
	      	ptotal = ptotal + tbProdutos[i]['propreco'];
	      }
	        linha = linha + "<tr><td>Quantidade</td><td><input name='tfQtde' class='form-control' type='text' value="+tbProdutos.length+" readonly='readonly'/></td>";
     		linha = linha + "<td>P.Total</td><td>R$"+ptotal+"</td></tr>";

     $("#produtos").html(linha);
 }
