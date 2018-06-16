/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function adicionaCarrinho(proid,cliid){
    $.post(${pageContext.request.contextPath}/"adicionaCarrinho", {'proid':proid}, {'cliid':cliid});
    
}