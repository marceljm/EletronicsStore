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
		map.put("Acessórios de Tecnologia", "fa fa-headphones");
		map.put("Alimentos e Bebidas", "fa fa-glass");
		map.put("Automotivo", "fa fa-car");
		map.put("Bebês e Crianças", "fa fa-child");
		map.put("Beleza", "fa fa-smile-o");
		map.put("Brinquedos", "fa fa-puzzle-piece");
		map.put("Cama Mesa e Banho", "fa fa-bed");
		map.put("Câmeras e Filmadoras", "fa fa-camera");
		map.put("Casa e Segurança", "fa fa-lock");
		map.put("CDs DVDs e Blu-Rays", "fa fa-film");
		map.put("Cuidados com a Saúde", "fa fa-stethoscope");
		map.put("Eletrodomésticos", "fa fa-plug");
		map.put("Eletrônicos", "fa fa-television");
		map.put("Eletroportáteis", "fa fa-power-off");
		map.put("Esporte e Lazer", "fa fa-trophy");
		map.put("Ferramentas", "fa fa-wrench");
		map.put("Games", "fa fa-rocket");
		map.put("Informática", "fa fa-laptop");
		map.put("Instrumentos musicais", "fa fa-music");
		map.put("Livros", "fa fa-book");
		map.put("Moda", "fa fa-shopping-bag");
		map.put("Móveis e Decoração", "fa fa-archive");
		map.put("Outros", "fa fa-circle-thin");
		map.put("Papelaria", "fa fa-file-text");
		map.put("Perfumaria e Cosméticos", "fa fa-user");
		map.put("Pet shop", "fa fa-paw");
		map.put("Produtos para Limpeza", "fa fa-trash-o	");
		map.put("Produtos sustentáveis", "fa fa-leaf");
		map.put("Relógios e Joias", "fa fa-diamond");
		map.put("Serviços", "fa fa-truck");
		map.put("Tablets", "fa fa-tablet");
		map.put("Telefonia", "fa fa-mobile");
		map.put("Utilidades domésticas", "fa fa-home");
	}

	@Override
	public String icon(String category) {
		return map.get(category);
	}

}
