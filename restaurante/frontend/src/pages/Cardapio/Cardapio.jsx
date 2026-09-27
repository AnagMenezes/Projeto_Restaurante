import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import './Cardapio.css'

function Cardapio() {

  const [categorias, setCategorias] = useState([])
  const [carregando, setCarregando] = useState(true)
  const [erro, setErro] = useState(false)

  useEffect(() => {
    fetch('http://localhost:8080/categoria')
      .then(response => response.json())
      .then(data => {
        setCategorias(data)
        setCarregando(false)
      })
      .catch(() => {
        setErro(true)
        setCarregando(false)
      })
  }, [])

  return (
    <main className="cardapio">

      <h1>Nosso Cardápio</h1>

      <p className="cardapio-intro">
        Conheça nossos pratos e sabores preparados com carinho.
      </p>

      <div className="cardapio-divisor">
  <span>✦</span>
</div>

<h2 className="categorias-titulo">
  Explore nossos sabores
</h2>

      {carregando && <p>Carregando categorias...</p>}

      {erro && (
        <p>Não foi possível carregar o cardápio.</p>
      )}

      <section className="categorias-cardapio">

        {categorias.map((categoria) => (

          <Link
  key={categoria.id}
  to={`/cardapio/categoria/${categoria.id}`}
  className="categoria-card"
>
  <h2>{categoria.nome}</h2>
</Link>

        ))}

      </section>

    </main>
  )
}

export default Cardapio