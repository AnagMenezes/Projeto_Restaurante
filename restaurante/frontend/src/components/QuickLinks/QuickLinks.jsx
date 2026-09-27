import { Link } from 'react-router-dom'
import './QuickLinks.css'

function QuickLinks() {
  return (
    <section className="quick-links">
      <h2>Conheça o Brasa de Carvalho</h2>

      <div className="quick-links-container">

        <Link to="/cardapio" className="quick-link">
          <h3>Cardápio</h3>
          <p>Confira nossos pratos e sabores.</p>
        </Link>

        <Link to = "/promocoes" className="quick-link">
          <h3>Promoções</h3>
          <p>Veja as novidades e ofertas da casa.</p>
        </Link>

        <Link to = "/eventos" className="quick-link">
          <h3>Eventos</h3>
          <p>Confira os próximos eventos do restaurante.</p>
        </Link>

      </div>
    </section>
  )
}

export default QuickLinks