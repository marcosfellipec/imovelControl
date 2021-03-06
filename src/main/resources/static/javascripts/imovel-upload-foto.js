var Bomfim = Bomfim || {};

Bomfim.UploadFoto = (function() {

	function UploadFoto() {
		this.inputNomeFoto = $('input[name=foto]');
		this.inputContentType = $('input[name=contentType]');
		this.htmlFotoImovelTemplate = $('#foto-imovel').html();
		this.template = Handlebars.compile(this.htmlFotoImovelTemplate);
		this.containerFotoImovel = $('.js-container-foto-imovel');
		this.uploadDrop = $('#upload-drop');
	}

	UploadFoto.prototype.iniciar = function() {
		var settings = {
			type : 'json',
			filelimit : 1,
			allow : '*.(jpg|jpeg|png)',
			action : this.containerFotoImovel.data('url-fotos'),
			complete : onUploadCompleto.bind(this),
			beforeSend : adicionarCsrfToken
		}
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);

		if (this.inputNomeFoto.val()) {
			onUploadCompleto.call(this, {
				nome : this.inputNomeFoto.val(),
				contentType : this.inputContentType.val()
			});
		}

	}

	function onUploadCompleto(resposta) {
		this.inputNomeFoto.val(resposta.nome);
		this.inputContentType.val(resposta.contentType);

		this.uploadDrop.addClass('hidden');
		var htmlFotoImovel = this.template({
			nomeFoto : resposta.nome
		});
		this.containerFotoImovel.append(htmlFotoImovel);

		$('.js-remove-foto').on('click', onRemoverFoto.bind(this));

		function onRemoverFoto() {
			$('.js-foto-imovel').remove();
			this.uploadDrop.removeClass('hidden');
			this.inputNomeFoto.val('');
			this.inputContentType.val('');
			$.ajax({
				url : '/imovelcontrol/fotos/tmp/' + resposta.nome,
				method : 'DELETE'
			});
		}
		;
	}

	function adicionarCsrfToken(xhr) {
		var token = $('input[name=_csrf]').val();
		var header = $('input[name=_crfs_header]').val();
		xhr.setRequestHeader(header, token);
	}

	return UploadFoto;

}());

$(function() {
	var uploadFoto = new Bomfim.UploadFoto();
	uploadFoto.iniciar();
});