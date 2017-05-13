package br.com.imovelcontrol.service;

import br.com.imovelcontrol.model.tipoimovel.Aluguel;
import br.com.imovelcontrol.repository.Alugueis;
import br.com.imovelcontrol.repository.FormasPagamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroAluguelService {

	@Autowired
    private Alugueis alugueis;

    @Autowired
    private FormasPagamentos formasPagamentos;

	@Transactional
	public Aluguel salvar(Aluguel aluguel) {
		return alugueis.save(aluguel);
	}

	@Transactional
	public void excluir(Aluguel aluguel) {
        alugueis.delete(aluguel);
        formasPagamentos.delete(aluguel.getFormaPagamento());
	}
}
