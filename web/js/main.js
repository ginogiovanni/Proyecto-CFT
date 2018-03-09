/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    
    $("input#rut").rut().on('rutInvalido', function(e) {
	alert("El rut " + $(this).val() + " es incorrecto");
    });
    
    $("input#rutAlumno").rut().on('rutInvalido', function(e) {
	alert("El rut " + $(this).val() + " es incorrecto");
    });
    $("input#rutDocente").rut().on('rutInvalido', function(e) {
	alert("El rut " + $(this).val() + " es incorrecto");
    });
    
    jQuery.validator.addMethod("lettersonly", function (value, element) {
        return this.optional(element) || /^[a-z\s]+$/i.test(value);
    }, "Solo letras porfavor");
    
    $('#frm-personal').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            rut: {
                required: true
            },
            nombre: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidos: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexo: {
                required: true
            },
            direccion: {
                required: true,
                rangelength: [1, 70]
            },
            telefono: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            email: {
                required: true,
                rangelength: [1, 100]
            }
        },
        messages: {
            rut: {
                required: "Debe ingresar un rut valido"
            },
            nombre: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidos: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexo: {
                required: "debe seleccionar un genero"
            },
            direccion: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefono: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            email: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-personal").serialize();

            console.log(data);
            $.post("../CrearPersonal", data, function (res, est, jqXHR) {

                $("#rut").val("");
                $("#nombre").val("");
                $("#apellidos").val("");
                $("#sexo").val("");
                $("#direccion").val("");
                $("#telefono").val("");
                $("#email").val("");
                if (res == '1') {
                    alert("Usuario registrado correctamente");
                    $("#collapseOne").collapse('hide');
                    setTimeout(function () {
                        window.location = "adminPersonal.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });

    $("#listadoPersonal").on("click", ".eliminarPersonal", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el usuario?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var rut = fila.find('#rut').text();
            var data = {rut: rut};
            $.post("../EliminarPersonal", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });

    $('#listadoPersonal').on("click", ".modificarPersonal", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var rut = fila.find('#rut').text();
        var nombre = fila.find('#nombre').text();
        var apellidos = fila.find('#apellido').text();
        var direccion = fila.find('#direccion').text();
        var telefono = fila.find('#telefono').text();
        var email = fila.find('#email').text();
        $("#rutM").val(rut);
        $("#nombreM").val(nombre);
        $("#apellidosM").val(apellidos);
        $("#direccionM").val(direccion);
        $("#telefonoM").val(telefono);
        $("#emailM").val(email);
        $("#collapseModificar").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });


    $('#frm-modificarPersonal').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            rutM: {
                required: true
            },
            nombreM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidosM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexoM: {
                required: true
            },
            direccionM: {
                required: true,
                rangelength: [1, 70]
            },
            telefonoM: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            emailM: {
                required: true,
                rangelength: [1, 100]
            }
        },
        messages: {
            rutM: {
                required: "Debe ingresar un rut valido"
            },
            nombreM: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidosM: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexoM: {
                required: "debe seleccionar un genero"
            },
            direccionM: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefonoM: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            emailM: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarPersonal').serialize();
            console.log(data);
            $.post("../ModificarPersonal", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Usuario modificado correctamente");
                    $("#collapseModificar").collapse('hide');
                    setTimeout(function () {
                        window.location = "adminPersonal.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });

    /*
     * #FIN FUNCIONES PERSONAL
     * 
     */
    
    /*
     * #FUNCIONES ALUMNOS
     * 
     */
    
    $('#listadoAlumno').on("click", ".modificarAlumno", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var rut = fila.find('#rut').text();
        var nombre = fila.find('#nombre').text();
        var apellidos = fila.find('#apellido').text();
        var direccion = fila.find('#direccion').text();
        var telefono = fila.find('#telefono').text();
        var email = fila.find('#email').text();
        $("#rutM").val(rut);
        $("#nombreM").val(nombre);
        $("#apellidosM").val(apellidos);
        $("#direccionM").val(direccion);
        $("#telefonoM").val(telefono);
        $("#emailM").val(email);
        $("#collapseModificarAlumno").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    
    
    $('#frm-modificarAlumno').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            rutM: {
                required: true
            },
            nombreM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidosM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexoM: {
                required: true
            },
            direccionM: {
                required: true,
                rangelength: [1, 70]
            },
            telefonoM: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            emailM: {
                required: true,
                rangelength: [1, 100]
            }
        },
        messages: {
            rutM: {
                required: "Debe ingresar un rut valido"
            },
            nombreM: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidosM: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexoM: {
                required: "debe seleccionar un genero"
            },
            direccionM: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefonoM: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            emailM: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarAlumno').serialize();
            console.log(data);
            $.post("../ModificarAlumno", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Alumno modificado correctamente");
                    $("#collapseModificarAlumno").collapse('hide');
                    setTimeout(function () {
                        window.location = "adminAlumnos.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
      /*
     * #FIN FUNCIONES ALUMNO
     * 
     */
    
    /*
     * #FUNCIONES MATRICULA
     * 
     */
    
    $('#frm-matricula').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            rut: {
                required: true
            },
            nombre: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidos: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexo: {
                required: true
            },
            direccion: {
                required: true,
                rangelength: [1, 70]
            },
            telefono: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            email: {
                required: true,
                rangelength: [1, 100]
            },
            carrera: {
                required: true
            },
            institucion: {
                required: true
            },
            ciclo: {
                required: true
            },
            modalidad: {
                required: true
            },
            semestre: {
                required: true
            },
            monto: {
                required: true,
                rangelength: [1, 7],
                number: true
            }
        },
        messages: {
            rut: {
                required: "Debe ingresar un rut valido"
            },
            nombre: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidos: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexo: {
                required: "debe seleccionar un genero"
            },
            direccion: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefono: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            email: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            },
            carrera: {
                required: "Debe seleccionar una carrera"
            },
            institucion: {
                required: "Debe seleccionar una institucion"
            },
            ciclo: {
                required: "Debe seleccionar un ciclo"
            },
            modalidad: {
                required: "Debe seleccionar una modalidad"
            },
            semestre: {
                required: "Debe seleccionar un semestre"
            },
            monto: {
                required: "Debe ingresar el monto",
                rangelength: "Solo 7 numeros",
                number: "Solo numeros"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-matricula").serialize();

            console.log(data);
            $.post("../CrearMatricula", data, function (res, est, jqXHR) {

                $("#rut").val("");
                $("#nombre").val("");
                $("#apellidos").val("");
                $("#sexo").val("");
                $("#direccion").val("");
                $("#telefono").val("");
                $("#email").val("");
                $("#monto").val("");
                if (res == '1') {
                    alert("Usuario registrado correctamente");
                    $("#collapseMatricula").collapse('hide');
                    setTimeout(function () {
                        window.location = "matriculas.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoMatricula').on("click", ".modificarMatricula", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var id = fila.find('#id').text();
        var rut = fila.find('#rut').text();
        var semestre = fila.find('#semestre').text();
        var monto = fila.find('#monto').text();
        $("#idM").val(id);
        $("#rutM").val(rut);
        $("#semestreM").val(semestre);
        $("#montoM").val(monto);
        $("#collapseModificarMatricula").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarMatricula').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            rutM: {
                required: true
            },
            semestreM: {
                required: true
            },
            montoM: {
                required: true,
                rangelength: [1, 7],
                number: true
            }
        },
        messages: {
            rutM: {
                required: "Debe ingresar un rut valido"
            },
            semestreM: {
                required: "Debe seleccionar un semestre"
            },
            montoM: {
                required: "Debe ingresar el monto",
                rangelength: "Solo 7 numeros",
                number: "Solo numeros"
            }
           
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarMatricula').serialize();
            console.log(data);
            $.post("../ModificarMatricula", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Matricula modificada correctamente");
                    $("#collapseModificarMatricula").collapse('hide');
                    setTimeout(function () {
                        window.location = "matriculas.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $("#carrera").change(function () {
           $("#carrera option:selected").each(function () {
            var id_carrera_fk = $(this).val();
            $.post("../GetCiclo", { id_carrera_fk: id_carrera_fk }, function(data){
                $("#ciclo").html(data);
            });            
        });
    });
     /*
     * #FIN FUNCIONES MATRICULA
     * 
     */
    
    /*
     * #FUNCIONES CARRERA
     * 
     */
    
    $('#frm-carrera').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            carrera: {
                required: true,
                rangelength: [1, 100]
            }
        },
        messages: {
            carrera: {
                required: "Debe ingresar una carrera",
                rangelength: "Solo 100 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-carrera").serialize();

            console.log(data);
            $.post("../CrearCarrera", data, function (res, est, jqXHR) {

                $("#carrera").val("");
                
                if (res == '1') {
                    alert("Carrera registrada correctamente");
                    $("#collapseCarrera").collapse('hide');
                    setTimeout(function () {
                        window.location = "carreras.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoCarrera').on("click", ".modificarCarrera", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var id = fila.find('#id').text();
        var carrera = fila.find('#carrera').text();
        $("#idM").val(id);
        $("#carreraM").val(carrera);
        $("#collapseModificarCarrera").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarCarrera').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            carreraM: {
                required: true,
                rangelength: [1, 100]
            }
        },
        messages: {
            carreraM: {
                required: "Debe ingresar una carrera",
                rangelength: "Solo 100 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarCarrera').serialize();
            console.log(data);
            $.post("../ModificarCarrera", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Carrera modificada correctamente");
                    $("#collapseModificarCarrera").collapse('hide');
                    setTimeout(function () {
                        window.location = "carreras.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $("#listadoCarrera").on("click", ".eliminarCarrera", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar la carrera?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarCarrera", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
    /*
     * #FIN FUNCIONES CARRERA
     * 
     */
    
    /*
     * #FUNCIONES INSTITUCION
     * 
     */
    
    $('#frm-institucion').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            institucion: {
                required: true,
                rangelength: [1, 50]
            }
        },
        messages: {
            institucion: {
                required: "Debe ingresar una institucion",
                rangelength: "Solo 50 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-institucion").serialize();

            console.log(data);
            $.post("../CrearInstitucion", data, function (res, est, jqXHR) {

                $("#institucion").val("");
                
                if (res == '1') {
                    alert("Institucion registrada correctamente");
                    $("#collapseInstitucion").collapse('hide');
                    setTimeout(function () {
                        window.location = "institucion.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoInstitucion').on("click", ".modificarInstitucion", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var id = fila.find('#id').text();
        var institucion = fila.find('#institucion').text();
        $("#idM").val(id);
        $("#institucionM").val(institucion);
        $("#collapseModificarInstitucion").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarInstitucion').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            institucionM: {
                required: true,
                rangelength: [1, 50]
            }
        },
        messages: {
            institucionM: {
                required: "Debe ingresar una institucion",
                rangelength: "Solo 50 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarInstitucion').serialize();
            console.log(data);
            $.post("../ModificarInstitucion", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Institucion modificada correctamente");
                    $("#collapseModificarInstitucion").collapse('hide');
                    setTimeout(function () {
                        window.location = "institucion.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $("#listadoInstitucion").on("click", ".eliminarInstitucion", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar la institucion?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarInstitucion", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
     /*
     * #FIN FUNCIONES INSTITUCIONES
     * 
     */
    
    /*
     * #FUNCIONES CICLO
     * 
     */
    
    $('#frm-ciclo').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            cod_ciclo: {
                required: true,
                rangelength: [1, 10]
            },
            desc_ciclo: {
                required: true,
                rangelength: [1, 50]
            },
            anio: {
                number: true,
                required: true,
                rangelength: [1, 4]
            }
        },
        messages: {
            cod_ciclo: {
                required: "Debe ingresar un codigo",
                rangelength: "Solo 10 caracteres"
            },
            desc_ciclo: {
                required: "Debe ingresar una descripción",
                rangelength: "Solo 50 Caracteres"
            },
            anio: {
                number: "Solo numeros",
                required: "Debe ingresar un año",
                rangelength: "Solo 4 numeros"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-ciclo").serialize();

            console.log(data);
            $.post("../CrearCiclo", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Ciclo registrado correctamente");
                    $("#collapseInstitucion").collapse('hide');
                    setTimeout(function () {
                        window.location = "ciclo.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#frm-modificarCiclo').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            cod_cicloM: {
                required: true,
                rangelength: [1, 10]
            },
            desc_cicloM: {
                required: true,
                rangelength: [1, 50]
            },
            anioM: {
                number: true,
                required: true,
                rangelength: [1, 4]
            }
        },
        messages: {
            cod_cicloM: {
                required: "Debe ingresar un codigo",
                rangelength: "Solo 10 caracteres"
            },
            desc_cicloM: {
                required: "Debe ingresar una descripción",
                rangelength: "Solo 50 Caracteres"
            },
            anioM: {
                number: "Solo numeros",
                required: "Debe ingresar un año",
                rangelength: "Solo 4 numeros"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-modificarCiclo").serialize();

            console.log(data);
            $.post("../ModificarCiclo", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Ciclo modificado correctamente");
                    $("#collapseInstitucion").collapse('hide');
                    setTimeout(function () {
                        window.location = "ciclo.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoCiclo').on("click", ".modificarCiclo", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var cod_ciclo = fila.find('#cod').text();
        var desc_ciclo = fila.find('#desc_ciclo').text();
        var anio = fila.find('#anio').text();
        $("#cod_cicloM").val(cod_ciclo);
        $("#desc_cicloM").val(desc_ciclo);
        $("#anioM").val(anio);
        $("#collapseModificarCiclo").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    
     /*
     * #FIN FUNCIONES CICLO
     * 
     */
    
    /*
     * #FUNCIONES ASIGNATURAS
     * 
     */
    $('#frm-asignatura').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            asignatura: {
                required: true,
                rangelength: [1, 90]
            }
        },
        messages: {
            asignatura: {
                required: "Debe ingresar una asignatura",
                rangelength: "Solo 90 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-asignatura").serialize();

            console.log(data);
            $.post("../CrearAsignatura", data, function (res, est, jqXHR) {

                $("#asignatura").val("");
                
                if (res == '1') {
                    alert("Asignatura registrada correctamente");
                    $("#collapseAsignatura").collapse('hide');
                    setTimeout(function () {
                        window.location = "asignatura.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#frm-modificarAsignatura').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            asignaturaM: {
                required: true,
                rangelength: [1, 90]
            }
        },
        messages: {
            asignaturaM: {
                required: "Debe ingresar una institucion",
                rangelength: "Solo 50 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarAsignatura').serialize();
            console.log(data);
            $.post("../ModificarAsignatura", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Institucion modificada correctamente");
                    $("#collapseModificarInstitucion").collapse('hide');
                    setTimeout(function () {
                        window.location = "asignatura.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoAsignatura').on("click", ".modificarAsignatura", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var id = fila.find('#id').text();
        var asignatura = fila.find('#asignatura').text();
        $("#idM").val(id);
        $("#asignaturaM").val(asignatura);
        $("#collapseModificarAsignatura").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    /*
     * #FIN FUNCIONES ASIGNATURA
     * 
     */
    
    /*
     * #FUNCIONES DOCENTE
     * 
     */
    
    $('#listadoDocente').on("click", ".modificarDocente", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var rut = fila.find('#rut').text();
        var nombre = fila.find('#nombre').text();
        var apellidos = fila.find('#apellido').text();
        var direccion = fila.find('#direccion').text();
        var telefono = fila.find('#telefono').text();
        var email = fila.find('#email').text();
        var titulo = fila.find('#titulo').text();
        $("#rutM").val(rut);
        $("#nombreM").val(nombre);
        $("#apellidosM").val(apellidos);
        $("#direccionM").val(direccion);
        $("#telefonoM").val(telefono);
        $("#emailM").val(email);
        $('#tituloM').val(titulo);
        $("#collapseModificarDocente").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarDocente').validate({
        
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        rules: {
            rutM: {
                required: true
            },
            nombreM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidosM: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexoM: {
                required: true
            },
            direccionM: {
                required: true,
                rangelength: [1, 70]
            },
            telefonoM: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            emailM: {
                required: true,
                rangelength: [1, 100]
            },
            tituloM: {
                required: true,
                rangelength: [1, 50]
            }
        },
        messages: {
            rutM: {
                required: "Debe ingresar un rut valido"
            },
            nombreM: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidosM: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexoM: {
                required: "debe seleccionar un genero"
            },
            direccionM: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefonoM: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            emailM: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            },
            tituloM: {
                required: "Debe ingresar un titulo",
                rangelength: "Solo 50 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $('#frm-modificarDocente').serialize();
            console.log(data);
            $.post("../ModificarDocente", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Docente modificado correctamente");
                    $("#collapseModificar").collapse('hide');
                    setTimeout(function () {
                        window.location = "docente.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    /*
     * #FIN FUNCIONES DOCENTES
     * 
     */
    
    /*
     * #FUNCIONES CONTRATO
     * 
     */
    
    $('#frm-contrato').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            rut: {
                required: true
            },
            nombre: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            apellidos: {
                required: true,
                rangelength: [1, 80],
                lettersonly: true
            },
            sexo: {
                required: true
            },
            direccion: {
                required: true,
                rangelength: [1, 70]
            },
            telefono: {
                required: true,
                rangelength: [1, 20],
                number: true
            },
            email: {
                required: true,
                rangelength: [1, 100]
            },
            titulo: {
                required: true,
                rangelength: [1, 60]
            },
            duracion: {
                required: true,
                rangelength: [1, 2],
                number: true
            },
            sueldo: {
                required: true,
                number: true
            }
        },
        messages: {
            rut: {
                required: "Debe ingresar un rut valido"
            },
            nombre: {
                required: "Debe ingresar un nombre",
                rangelength: "Solo 80 caracteres"
            },
            apellidos: {
                required: "Debe ingresar un apellido",
                rangelength: "Solo 80 caracteres"
            },
            sexo: {
                required: "debe seleccionar un genero"
            },
            direccion: {
                required: "Debe ingresar una direccion",
                rangelength: "Solo 70 caracteres"
            },
            telefono: {
                required: "Debe ingresar un telefono",
                rangelength: "Solo 20 caracteres",
                number: "Solo numeros"
            },
            email: {
                required: "Debe ingresar un email",
                rangelength: "Solo 100 caracteres"
            },
            titulo: {
                required: "Debe ingresar un titulo",
                rangelength: "Solo 60 caracteres"
            },
            duracion: {
                required: "Debe ingresar la duracion del contrato",
                rangelength: "Solor numeros menores de 99",
                number: "Solo numeros"
            },
            sueldo: {
                required: "Debe ingresar el sueldo bruto",
                number: "Solo numeros"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-contrato").serialize();

            console.log(data);
            $.post("../CrearContrato", data, function (res, est, jqXHR) {

                $("#rut").val("");
                $("#nombre").val("");
                $("#apellidos").val("");
                $("#sexo").val("");
                $("#direccion").val("");
                $("#telefono").val("");
                $("#email").val("");
                $("#titulo").val("");
                $("#duracion").val("");
                $("#sueldo").val("");
                if (res == '1') {
                    alert("Contrato ingresado correctamente");
                    $("#collapseContrato").collapse('hide');
                    setTimeout(function () {
                        window.location = "contrato.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoContrato').on("click", ".modificarContrato", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var rut = fila.find('#rut').text();
        var duracion = fila.find('#duracion').text();
        var salud = fila.find('#salud').text();
        var sueldo = fila.find('#sueldo').text();
        $("#rutM").val(rut);
        $("#duracionM").val(duracion);
        $("#saludM").val(salud);
        $("#sueldoM").val(sueldo);
        $("#collapseModificarContrato").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarContrato').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            duracionM: {
                required: true,
                rangelength: [1, 2],
                number: true
            },
            sueldoM: {
                required: true,
                number: true
            }
        },
        messages: {
            duracionM: {
                required: "Debe ingresar la duracion del contrato",
                rangelength: "Solor numeros menores de 99",
                number: "Solo numeros"
            },
            sueldoM: {
                required: "Debe ingresar el sueldo bruto",
                number: "Solo numeros"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-modificarContrato").serialize();

            console.log(data);
            $.post("../ModificarContrato", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Contrato modificado correctamente");
                    $("#collapseContrato").collapse('hide');
                    setTimeout(function () {
                        window.location = "contrato.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    /*
     * #FIN FUNCIONES DOCENTES
     * 
     */
    
    /*
     * #FUNCIONES MANT ASIGNATURAS
     * 
     */
    
     $('#frm-mantAsignatura').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            rutDocente: {
                required: true,
                rangelength: [1, 20]
            },
            rutAlumno: {
                required: true,
                rangelength: [1, 20]
            }
        },
        messages: {
            rutDocente: {
                required: "El rut debe ser ingresado",
                rangelength: "Ingrese un rut valido"
            },
            rutAlumno: {
                required: "El rut del alumno debe ser ingresado",
                rangelength: "Ingrese un rut valido"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-mantAsignatura").serialize();

            console.log(data);
            $.post("../CrearMantAsignatura", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Registro ingresado correctamente");
                    $("#collapseMantAsignatura").collapse('hide');
                    setTimeout(function () {
                        window.location = "mantAsignatura.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $("#listadoMantAsignatura").on("click", ".eliminarMantAsignatura", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el registro?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarMantAsignatura", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
       /*
     * #FIN FUNCIONES mant asignaturas
     * 
     */
    
    /*
     * #FUNCIONES MANT DETALLE PAGOS
     * 
     */
    
     $('#frm-detallePago').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-detallePago").serialize();

            console.log(data);
            $.post("../GenerarPago", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Pago generado correctamente");
                    $("#collapseMantAsignatura").collapse('hide');
                    setTimeout(function () {
                        window.location = "DetallePagoTotal.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    $("#listadoPago").on("click", ".eliminarDetallePago", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el registro?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarDetallePago", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
       /*
     * #FIN FUNCIONES MANT DETALLE PAGOS
     * 
     */
    
    /*
     * #FUNCIONES usuarios
     * 
     */
    
    $("#frm-login").validate({
        rules: {
            usuario: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            usuario: {
                required: "*El campo nombre de usuario es obligatorio"
            },
            password: {
                required: "el campo password es obligatorio"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para validar
            var data = $("#frm-login").serialize();
            $.post("Autenticar", data, function (res, est, jqXHR) {
                if (res == '1') {
                    alert("Bienvenido, precione aceptar para ser redireccionado");
                    setTimeout(function () {
                        window.location = "index.jsp";
                    }, 300);
                } else {
                    $("#msg").text("Credenciales Incorrectas, reintente porfavor ");
                }
            });
        }
    });
    
    $('#frm-usuariosPersonal').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuario: {
                required: true,
                rangelength: [1, 50]
            },
            password: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuario: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            password: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-usuariosPersonal").serialize();

            console.log(data);
            $.post("../CrearUsuariosPersonal", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Registro ingresado correctamente");
                    $("#collapseUsuariosPersonal").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_personal.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    $('#listadoPersonal').on("click", ".modificarUsuarioPersonal", function (e) {
        e.preventDefault();
        var fila = $(this).parent().parent();
        var id = fila.find('#id').text();
        var usuario = fila.find('#usuario').text();
        var password = fila.find('#password').text();
        $("#idM").val(id);
        $("#usuarioM").val(usuario);
        $("#passwordM").val(password);
        $("#collapseModificarUsuario").collapse('show');
        /*var data = {idUsuario: idusuario};
         $.post("modificarUsuario", data, function (res, est, jqXHR) {
         alert(res);
         fila.remove();
         });*/
    });
    
    $('#frm-modificarUsuario').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuarioM: {
                required: true,
                rangelength: [1, 50]
            },
            passwordM: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuarioM: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            passwordM: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-modificarUsuario").serialize();

            console.log(data);
            $.post("../ModificarUsuario", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Usuario modificado correctamente");
                    $("#collapseContrato").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_personal.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
     $("#listadoPersonal").on("click", ".eliminarUsuarioPersonal", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el registro?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarUsuarioPersonal", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
    //--------------------------------------------------------
    
    $('#frm-usuariosAlumno').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuario: {
                required: true,
                rangelength: [1, 50]
            },
            password: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuario: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            password: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-usuariosAlumno").serialize();

            console.log(data);
            $.post("../CrearUsuarioAlumno", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Registro ingresado correctamente");
                    $("#collapseUsuariosPersonal").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_alumnos.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    
    $('#frm-modificarUsuarioAlumno').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuarioM: {
                required: true,
                rangelength: [1, 50]
            },
            passwordM: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuarioM: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            passwordM: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-modificarUsuarioAlumno").serialize();

            console.log(data);
            $.post("../ModificarUsuario", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Usuario modificado correctamente");
                    $("#collapseContrato").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_alumnos.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
     $("#listadoPersonal").on("click", ".eliminarUsuarioAlumno", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el registro?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarUsuarioAlumno", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });
    
    //-------------------------------------
    
    
    $('#frm-usuariosDocente').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuario: {
                required: true,
                rangelength: [1, 50]
            },
            password: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuario: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            password: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-usuariosDocente").serialize();

            console.log(data);
            $.post("../CrearUsuarioDocente", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Registro ingresado correctamente");
                    $("#collapseUsuariosPersonal").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_docentes.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
    
    $('#frm-modificarUsuarioDocente').validate({
        errorClass: "my-error-class",
        validClass: "my-valid-class",
        rules: {
            usuarioM: {
                required: true,
                rangelength: [1, 50]
            },
            passwordM: {
                required: true,
                rangelength: [1, 25]
            }
        },
        messages: {
            usuarioM: {
                required: "El usuario debe ser ingresado",
                rangelength: "Ingrese un usuario valido"
            },
            passwordM: {
                required: "El password debe ser ingresado",
                rangelength: "Solo 25 caracteres"
            }
        },
        submitHandler: function (form) {
            //funcion ajax para crear usuario
            var data = $("#frm-modificarUsuarioDocente").serialize();

            console.log(data);
            $.post("../ModificarUsuario", data, function (res, est, jqXHR) {
                
                if (res == '1') {
                    alert("Usuario modificado correctamente");
                    $("#collapseContrato").collapse('hide');
                    setTimeout(function () {
                        window.location = "usuarios_docentes.jsp";
                    }, 300);
                } else {
                    alert("error inesperado");
                }
            });
        }
    });
    
     $("#listadoPersonal").on("click", ".eliminarUsuarioDocente", function (e) {
        e.preventDefault();
        var opcion = confirm("Desea eliminar el registro?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var id = fila.find('#id').text();
            var data = {id: id};
            $.post("../EliminarUsuarioDocente", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }
    });



});



