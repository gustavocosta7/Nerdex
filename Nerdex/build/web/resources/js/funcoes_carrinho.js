/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
      var tbProdutos = localStorage.getItem("tbProdutos");
      tbProdutos = JSON.parse(tbProdutos);
      var linha = "<thead><tr><th>ID</th><th>Nome</th><th>Preço</th></tr></thead>";
      
      for(i = 0 ; i < tbProdutos.length ; i++){
      	linha = linha+"<tr><td>"+tbProdutos[i]['proid']+"</td><td>"+tbProdutos[i]['pronome']+"</td><td>"+tbProdutos[i]['propreco']+"</td></tr>";

      }

      $("#produtos").html(linha);

  });
