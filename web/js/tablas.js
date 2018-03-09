/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('table.display').DataTable({
        "language": {
            "decimal": ".",
            "emptyTable": "No hay datos para mostrar",
            "info": "del _START_ al _END_ (_TOTAL_ total)",
            "infoEmpty": "del 0 al 0 (0 total)",
            "infoFiltered": "(filtrado de todas las _MAX_ entradas)",
            "infoPostFix": "",
            "thousands": "'",
            "lengthMenu": "Mostrar _MENU_ entradas",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "No hay resultados",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": ": ordenar de manera Ascendente",
                "sortDescending": ": ordenar de manera Descendente "
            }
        }
    });
});