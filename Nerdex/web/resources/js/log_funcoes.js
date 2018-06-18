/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global LocalStorage */

$(document).ready(function(){
      var tbProdutos = localStorage.getItem("tbProdutos");
      tbProdutos = JSON.parse(tbProdutos);
    
      $("#qtde").html(tbProdutos.length);

});

function adicionaCarrinho(proid,pronome,propreco){

    var produto = new Object();
    produto.proid = proid;
    produto.pronome = pronome;
    produto.propreco = propreco;

    var tbProdutos = localStorage.getItem("tbProdutos");
    tbProdutos = JSON.parse(tbProdutos);
   
    if(tbProdutos == null)
    	tbProdutos = [];

    tbProdutos.push(produto);
    localStorage.setItem("tbProdutos",JSON.stringify(tbProdutos));
    alert("produto adicionado com sucesso");
    
//    alert(quantidadeProduto(tbProdutos, proid));
    cont = 0;
    for(i = 0; i < tbProdutos.length; i++){
        if(tbProdutos[i] == proid){
            cont++;
        }
    }
    $("#qtde").html(tbProdutos.length);
}

