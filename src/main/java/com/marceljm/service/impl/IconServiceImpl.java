package com.marceljm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.marceljm.service.IconService;

@Service
public class IconServiceImpl implements IconService {

	private Map<String, String> map = new HashMap<String, String>();

	@PostConstruct
	private void init() {
		map.put("Acess�rios de Tecnologia", "fa fa-headphones");
		map.put("Alimentos e Bebidas", "fa fa-glass");
		map.put("Automotivo", "fa fa-car");
		map.put("Beb�s e Crian�as", "fa fa-child");
		map.put("Beleza", "fa fa-smile-o");
		map.put("Brinquedos", "fa fa-puzzle-piece");
		map.put("Cama Mesa e Banho", "fa fa-bed");
		map.put("C�meras e Filmadoras", "fa fa-camera");
		map.put("Casa e Seguran�a", "fa fa-lock");
		map.put("CDs DVDs e Blu-Rays", "fa fa-film");
		map.put("Cuidados com a Sa�de", "fa fa-stethoscope");
		map.put("Eletrodom�sticos", "fa fa-plug");
		map.put("Eletr�nicos", "fa fa-television");
		map.put("Eletroport�teis", "fa fa-power-off");
		map.put("Esporte e Lazer", "fa fa-trophy");
		map.put("Ferramentas", "fa fa-wrench");
		map.put("Games", "fa fa-rocket");
		map.put("Inform�tica", "fa fa-laptop");
		map.put("Instrumentos musicais", "fa fa-music");
		map.put("Livros", "fa fa-book");
		map.put("Moda", "fa fa-shopping-bag");
		map.put("M�veis e Decora��o", "fa fa-archive");
		map.put("Outros", "fa fa-circle-thin");
		map.put("Papelaria", "fa fa-file-text");
		map.put("Perfumaria e Cosm�ticos", "fa fa-user");
		map.put("Pet shop", "fa fa-paw");
		map.put("Produtos para Limpeza", "fa fa-trash-o	");
		map.put("Produtos sustent�veis", "fa fa-leaf");
		map.put("Rel�gios e Joias", "fa fa-diamond");
		map.put("Servi�os", "fa fa-truck");
		map.put("Tablets", "fa fa-tablet");
		map.put("Telefonia", "fa fa-mobile");
		map.put("Utilidades dom�sticas", "fa fa-home");
	}

	@Override
	public String icon(String category) {
		return map.get(category);
	}

}
