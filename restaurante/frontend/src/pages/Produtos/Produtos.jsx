import { useState, useEffect } from 'react'

import './Produtos.css'

function Produtos() {

  const [nome, setNome] = useState('')
  const [descricao, setDescricao] = useState('')
  const [preco, setPreco] = useState('')
  const [imagem, setImagem] = useState('')

  const [categorias, setCategorias] = useState([])
  const [categoriaId, setCategoriaId] = useState('')
  const [disponivel, setDisponivel] = useState(true)

  const [produtos, setProdutos] = useState([])

  const [editandoId, setEditandoId] = useState(null)


  // CADASTRAR PRODUTO
  const cadastrarProduto = (e) => {
    e.preventDefault()

    console.log('Categoria escolhida:', categoriaId)

    fetch('http://localhost:8080/produtos', {
      method: 'POST',

      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify({
        nome: nome,
        descricao: descricao,
        preco: Number(preco),
        imagem: imagem,
        disponivel: disponivel,
        categoria: {
          id: Number(categoriaId)
        }
      })
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Erro ao cadastrar produto')
        }

        return response.json()
      })
      .then(novoProduto => {
        console.log('Produto recebido depois do cadastro:', novoProduto)
        setProdutos([...produtos, novoProduto])

        setNome('')
        setDescricao('')
        setPreco('')
        setImagem('')
        setCategoriaId('')
        setDisponivel(true)
      })
      .catch(error => {
        console.error(error)
      })
  }


  // BUSCAR CATEGORIAS
  useEffect(() => {
    fetch('http://localhost:8080/categoria')
      .then(response => response.json())
      .then(data => {
        setCategorias(data)
      })
  }, [])


  // BUSCAR PRODUTOS
  useEffect(() => {
    fetch('http://localhost:8080/produtos')
      .then(response => response.json())
      .then(data => {
        setProdutos(data)
      })
  }, [])


  // EXCLUIR PRODUTO
  const excluirProduto = (id) => {

    const confirmar = window.confirm(
      'Tem certeza que deseja excluir este produto?'
    )

    if (!confirmar) {
      return
    }

    fetch(`http://localhost:8080/produtos/${id}`, {
      method: 'DELETE'
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Erro ao excluir produto')
        }

        setProdutos(
          produtos.filter(produto => produto.id !== id)
        )
      })
      .catch(error => {
        console.error(error)
      })
  }


  // COLOCAR PRODUTO NO FORMULÁRIO PARA EDITAR
  const editarProduto = (produto) => {

    setEditandoId(produto.id)

    setNome(produto.nome)
    setDescricao(produto.descricao)
    setPreco(produto.preco)
    setImagem(produto.imagem)
    setCategoriaId(produto.categoria.id)
    setDisponivel(produto.disponivel)
  }


  // ATUALIZAR PRODUTO
  const atualizarProduto = (e) => {
    e.preventDefault()

    fetch(`http://localhost:8080/produtos/${editandoId}`, {
      method: 'PUT',

      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify({
        nome: nome,
        descricao: descricao,
        preco: Number(preco),
        imagem: imagem,
        disponivel: disponivel,
        categoria: {
          id: Number(categoriaId)
        }
      })
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Erro ao atualizar produto')
        }

        return response.json()
      })
      .then(produtoAtualizado => {

        setProdutos(
          produtos.map(produto =>
            produto.id === editandoId
              ? produtoAtualizado
              : produto
          )
        )

        setEditandoId(null)

        setNome('')
        setDescricao('')
        setPreco('')
        setImagem('')
        setCategoriaId('')
        setDisponivel(true)
      })
      .catch(error => {
        console.error(error)
      })
  }


  return (
    <main className="produtos">

      <h1>Gerenciar Produtos</h1>

<form

  className="produto-form"
  onSubmit={editandoId ? atualizarProduto : cadastrarProduto}
>

  <h2>
  {editandoId ? 'Editar produto' : 'Novo produto'}
</h2>
        <select
          value={categoriaId}
          onChange={(e) => setCategoriaId(e.target.value)}
        >
          <option value="">
            Selecione uma categoria
          </option>

          {categorias.map((categoria) => (
            <option
              key={categoria.id}
              value={categoria.id}
            >
              {categoria.nome}
            </option>
          ))}
        </select>


        <label>

          <input
            type="checkbox"
            checked={disponivel}
            onChange={(e) => setDisponivel(e.target.checked)}
          />

          Produto disponível

        </label>


        <input
          type="text"
          placeholder="Nome do produto"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
        />


        <input
          type="text"
          placeholder="Descrição"
          value={descricao}
          onChange={(e) => setDescricao(e.target.value)}
        />


        <input
          type="number"
          placeholder="Preço"
          value={preco}
          onChange={(e) => setPreco(e.target.value)}
        />


        <input
          type="text"
          placeholder="Imagem"
          value={imagem}
          onChange={(e) => setImagem(e.target.value)}
        />


        <button type="submit">

          {editandoId
            ? 'Salvar alterações'
            : 'Cadastrar produto'}

        </button>

      </form>


      <section className="produtos-lista">

        <h2>Produtos cadastrados</h2>

        {produtos.map((produto) => (

          <div
            className="produto-item"
            key={produto.id}
          >

            <h3>{produto.nome}</h3>

            <p>{produto.descricao}</p>

            <p>R$ {produto.preco}</p>

            <p>
              Categoria: {produto.categoria?.nome}
            </p>


            <button
              onClick={() => editarProduto(produto)}
            >
              Editar
            </button>


            <button
              onClick={() => excluirProduto(produto.id)}
            >
              Excluir
            </button>

          </div>

        ))}

      </section>

    </main>
  )
}

export default Produtos