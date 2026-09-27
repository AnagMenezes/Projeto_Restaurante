import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import ProdutoCard from '../../components/ProdutoCard/ProdutoCard'
import './CardapioCategoria.css'

function CardapioCategoria() {

  const { id } = useParams()

  const [categoria, setCategoria] = useState(null)
const [produtos, setProdutos] = useState([])
const [carregando, setCarregando] = useState(true)
const [erro, setErro] = useState(false)
  useEffect(() => {
    fetch('http://localhost:8080/produtos')
      .then(response => response.json())
      .then(data => {

        const produtosDaCategoria = data.filter(
          produto => produto.categoria?.id === Number(id)
        )

        setProdutos(produtosDaCategoria)
        setCarregando(false)
      })
      .catch(() => {
        setErro(true)
        setCarregando(false)
      })
  }, [id],

fetch(`http://localhost:8080/categoria/${id}`)
  .then(response => response.json())
  .then(data => {
    setCategoria(data)
  }))

  return (
    <main className="cardapio-categoria">

      <h1>{categoria?.nome}</h1>

      {carregando && <p>Carregando produtos...</p>}

      {erro && (
        <p>Não foi possível carregar os produtos.</p>
      )}

      <div className="produtos-container">

        {produtos.map((produto) => (
          <ProdutoCard
            key={produto.id}
            nome={produto.nome}
            descricao={produto.descricao}
            preco={produto.preco}
          />
        ))}

      </div>

    </main>
  )
}

export default CardapioCategoria