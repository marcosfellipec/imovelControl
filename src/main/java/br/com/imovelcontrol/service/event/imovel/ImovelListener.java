package br.com.imovelcontrol.service.event.imovel;

import br.com.imovelcontrol.storage.FotoStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ImovelListener {

	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#imovelSalvaEvent.foto")
	public void imovelSalvo(ImovelSalvaEvent imovelSalvaEvent){
		fotoStorage.salvar(imovelSalvaEvent.getImovel().getFoto());
		System.out.println("tem foto" + imovelSalvaEvent.getImovel().getFoto());
	}
}
